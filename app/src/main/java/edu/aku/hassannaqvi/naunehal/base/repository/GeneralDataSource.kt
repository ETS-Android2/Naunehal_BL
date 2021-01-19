package edu.aku.hassannaqvi.naunehal.base.repository

import edu.aku.hassannaqvi.naunehal.models.*
import kotlin.collections.ArrayList

interface GeneralDataSource {

    /*
    * For login Start
    * */
    suspend fun getLoginInformation(username: String, password: String): Users?
    /*
    * For login End
    * */

    /*
    * For MainActivity Start
    * */
    suspend fun getFormsByDate(date: String): ArrayList<Form>

    suspend fun getUploadStatus(): FormIndicatorsModel

    suspend fun getFormStatus(date: String): FormIndicatorsModel
    /*
    * For MainActivity End
    * */

    /*
    * For Child List
    * */
    suspend fun getChildList(cluster: String, hhno: String, uuid: String): ArrayList<ChildInformation>

    suspend fun updateSpecificChildList(info: ChildInformation, isSelected: String): Int
    /*
    * For Child List End
    * */

    /*
    * For SectionH1
    * */
    suspend fun getDistrictsFromDB(): ArrayList<Districts>

    suspend fun getUcsByDistrictsFromDB(dCode: String): ArrayList<UCs>

    suspend fun getBLByDistrictsFromDB(distCode: String, cluster: String, hhno: String): BLRandom
    /*
    * For SectionH1 End
    * */

    /*
    * For Section Selected ChildList
    * */
    suspend fun getSelectedChildList(cluster: String, hhno: String, uuid: String): ArrayList<ChildInformation>
    /*
    * For SectionH1 End
    * */

}