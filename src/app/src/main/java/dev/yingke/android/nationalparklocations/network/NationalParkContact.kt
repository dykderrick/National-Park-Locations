package dev.yingke.android.nationalparklocations.network

data class NationalParkContact(
    val phoneNumbers: List<PhoneNumber>,
    val emailAddresses: List<EmailAddress>,
)

data class PhoneNumber(
    val phoneNumber: String,
    val description: String,
    val extension: String,
    val type: String,
)

data class EmailAddress(
    val description: String,
    val emailAddress: String,
)
