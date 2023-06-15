package com.example.myapplication.recyclerview.models

class DataSource {
    fun getNames(): List<String> {
        val data = ArrayList<String>()
        for (i in 0..100) {
            data.add("$i Element")
        }
        return data
    }

    fun getFolderDetails(): ArrayList<Folder> {
        val folders = ArrayList<Folder>()
        folders.add(Folder("Games", "54 items"))
        folders.add(Folder("Movies", "64 items"))
        folders.add(Folder("Projects", "5 items"))
        folders.add(Folder("College materials", "36 items"))
        folders.add(Folder("Photos", "56 items"))
        folders.add(Folder("Screenshots", "554 items"))
        folders.add(Folder("Recordings", "124 items"))
        folders.add(Folder("Trips", "414 items"))
        folders.add(Folder("Home", "95 items"))
        folders.add(Folder("Notes", "76 items"))
        folders.add(Folder("Android projects", "6 items"))
        folders.add(Folder("iOS projects", "4 items"))
        folders.add(Folder("Recycle bin", "9 items"))
        return folders
    }

    fun getEmails(): ArrayList<Mail> {
        val emails = ArrayList<Mail>()
        emails.add(
            Mail(
                senderName = "Shubham J",
                subject = "Android",
                email = "Starting new bootcamp register now",
                timeStamp = "12:00 am"
            )
        )
        emails.add(
            Mail(
                senderName = "Shyam S",
                subject = "Python",
                email = "Starting new bootcamp register now",
                timeStamp = "06:00 am"
            )
        )
        emails.add(
            Mail(
                senderName = "Manthan N",
                subject = "Data science",
                email = "Starting new bootcamp register now",
                timeStamp = "12:20 pm",
                isImportant = true,
                attachment = true
            )
        )
        emails.add(
            Mail(
                senderName = "Divyesh V",
                subject = "Python",
                email = "Starting new bootcamp register now",
                timeStamp = "11:00 pm"
            )
        )
        emails.add(
            Mail(
                senderName = "Devanash N",
                subject = "Data science",
                email = "Starting new bootcamp register now",
                timeStamp = "12:20 pm",
                isImportant = true
            )
        )
        emails.add(
            Mail(
                senderName = "Ami T",
                subject = "Java",
                email = "Starting new bootcamp register now",
                timeStamp = "02:00 am"
            )
        )
        emails.add(
            Mail(
                senderName = "Rahul N",
                subject = "Data science",
                email = "Starting new bootcamp register now",
                timeStamp = "12:20 pm",
                attachment = true
            )
        )
        emails.add(
            Mail(
                senderName = "Bhakti T",
                subject = "Java",
                email = "Starting new bootcamp register now",
                timeStamp = "02:00 am"
            )
        )
        return emails
    }

    private fun getPreviousMails(): ArrayList<MailChild> {
        val previousMails = ArrayList<MailChild>()
        previousMails.add(MailChild("Data science bootcamp", "12:35 am"))
        previousMails.add(MailChild("Android bootcamp", "11:35 am"))
        previousMails.add(MailChild("iOS bootcamp", "11:35 am"))
        previousMails.add(MailChild("Level up your DSA", "01:35 pm"))
        return previousMails
    }

    fun getExpandableMails(): MutableList<MailParent> {
        val emails = DataSource().getEmails()
        val previousMails = DataSource().getPreviousMails()
        val parentMail: MutableList<MailParent> = ArrayList()
        for (mail in emails) {
            parentMail.add(MailParent(mail, sublist = previousMails))
        }
        return parentMail
    }

    fun getMailContacts(): MutableList<Contact> {
        val contacts: MutableList<Contact> = ArrayList()
        contacts.add(Contact("Shubham Jitiya", "jitiya66@gmail.com", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document"))
        contacts.add(Contact("Bhakti Trivedi", "bhakti@gmail.com", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document"))
        contacts.add(Contact("Shyam Sartanpara", "sartanpara@gmail.com", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document"))
        contacts.add(Contact("Manthan Nagpurkar", "nargpukar@gmail.com", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document"))
        contacts.add(Contact("Devansh Shah", "shah@gmail.com", "In publishing and graphic design, Lorem ipsum is a placeholder text commonly used to demonstrate the visual form of a document"))
        return contacts
    }
}