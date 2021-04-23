package th.co.toei.examdtac.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import th.co.toei.examdtac.model.ContactModel

interface EndpointInterface {
    @GET("api")
    fun getContactData(@Query("results") input: Int): Observable<ContactModel>
}
