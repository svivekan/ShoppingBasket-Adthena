case class Contact(name: String, email: Option[String])

case class Email(name: String, address: String)


val jay = Contact("jay", Some("jay@hotmail.com"))
val kal = Contact("kal", None)

val jemail = Email("jay", "jay@email")
val kemail = Email("kay", "kay@email")

def checker(item1: String, item2: String): Boolean = {
  item1 == item2
}


val contacts = List(jay, kal)
val emails = List(jemail, kemail)

for {
  contact <- contacts
  email <- emails if ((contact.name) != (email.name))
  //  email <- emails if (!checker(contact.name, email.name))
  email <- emails
} yield


