package th.co.toei.examdtac.model
import com.google.gson.annotations.SerializedName


data class ContactModel(
    @SerializedName("info")
    val info: Info? = Info(),
    @SerializedName("results")
    val results: MutableList<Result> = mutableListOf()
)

data class Info(
    @SerializedName("page")
    val page: Int? = 0,
    @SerializedName("results")
    val results: Int? = 0,
    @SerializedName("seed")
    val seed: String? = "",
    @SerializedName("version")
    val version: String? = ""
)

data class Result(
    @SerializedName("cell")
    val cell: String? = "",
    @SerializedName("dob")
    val dob: Dob = Dob(),
    @SerializedName("email")
    val email: String? = "",
    @SerializedName("gender")
    val gender: String? = "",
    @SerializedName("id")
    val id: Id? = Id(),
    @SerializedName("location")
    val location: Location? = Location(),
    @SerializedName("login")
    val login: Login? = Login(),
    @SerializedName("name")
    val name: Name = Name(),
    @SerializedName("nat")
    val nat: String? = "",
    @SerializedName("phone")
    val phone: String? = "",
    @SerializedName("picture")
    val picture: Picture? = Picture(),
    @SerializedName("registered")
    val registered: Registered? = Registered()
)

data class Dob(
    @SerializedName("age")
    val age: Int = 0,
    @SerializedName("date")
    val date: String = ""
)

data class Id(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("value")
    val value: Any? = Any()
)

data class Location(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("coordinates")
    val coordinates: Coordinates? = Coordinates(),
    @SerializedName("country")
    val country: String? = "",
    @SerializedName("postcode")
    val postcode: Int? = 0,
    @SerializedName("state")
    val state: String? = "",
    @SerializedName("street")
    val street: Street? = Street(),
    @SerializedName("timezone")
    val timezone: Timezone? = Timezone()
)

data class Login(
    @SerializedName("md5")
    val md5: String? = "",
    @SerializedName("password")
    val password: String? = "",
    @SerializedName("salt")
    val salt: String? = "",
    @SerializedName("sha1")
    val sha1: String? = "",
    @SerializedName("sha256")
    val sha256: String? = "",
    @SerializedName("username")
    val username: String? = "",
    @SerializedName("uuid")
    val uuid: String? = ""
)

data class Name(
    @SerializedName("first")
    val first: String = "",
    @SerializedName("last")
    val last: String = "",
    @SerializedName("title")
    val title: String = ""
)

data class Picture(
    @SerializedName("large")
    val large: String = "",
    @SerializedName("medium")
    val medium: String = "",
    @SerializedName("thumbnail")
    val thumbnail: String = ""
)

data class Registered(
    @SerializedName("age")
    val age: Int? = 0,
    @SerializedName("date")
    val date: String? = ""
)

data class Coordinates(
    @SerializedName("latitude")
    val latitude: String? = "",
    @SerializedName("longitude")
    val longitude: String? = ""
)

data class Street(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("number")
    val number: Int? = 0
)

data class Timezone(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("offset")
    val offset: String? = ""
)