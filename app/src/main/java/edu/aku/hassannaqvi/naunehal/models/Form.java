package edu.aku.hassannaqvi.naunehal.models;

import android.database.Cursor;
import android.util.Log;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.GsonBuilder;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.threeten.bp.LocalDate;

import edu.aku.hassannaqvi.naunehal.BR;
import edu.aku.hassannaqvi.naunehal.contracts.FormsContract;
import edu.aku.hassannaqvi.naunehal.core.MainApp;

public class Form extends BaseObservable {

    private final String TAG = "Form";

    // APP VARIABLES
    private String projectName = MainApp.PROJECT_NAME;
    // FIELD VARIABLES
    public String hh01 = StringUtils.EMPTY;
    public String hh0201 = StringUtils.EMPTY;
    public String hh0202 = StringUtils.EMPTY;
    public String hh03 = StringUtils.EMPTY;
    public String hh04 = StringUtils.EMPTY;
    public String hh05 = StringUtils.EMPTY;
    public String hh06 = StringUtils.EMPTY;
    public String hh07 = StringUtils.EMPTY;
    public String hh08 = StringUtils.EMPTY;
    public String hh09 = StringUtils.EMPTY;
    public String hh10 = StringUtils.EMPTY;
    public String hh11 = StringUtils.EMPTY;
    public String hh12 = StringUtils.EMPTY;
    public String hh13 = StringUtils.EMPTY;
    public String hh14 = StringUtils.EMPTY;
    public String hh15 = StringUtils.EMPTY;
    public String hh16 = StringUtils.EMPTY;
    public String hh17 = StringUtils.EMPTY;
    public String hh1796x = StringUtils.EMPTY;
    public String hh18 = StringUtils.EMPTY;
    public String hh19 = StringUtils.EMPTY;
    public String hh20 = StringUtils.EMPTY;
    public String hh2096x = StringUtils.EMPTY;
    public String hh21 = StringUtils.EMPTY;
    public String hh22 = StringUtils.EMPTY;
    public String hh23 = StringUtils.EMPTY;
    public String hh24 = StringUtils.EMPTY;
    public String hh25 = StringUtils.EMPTY;
    public String hh26 = StringUtils.EMPTY;
    public String hh2696x = StringUtils.EMPTY;
    //Section PD
    public String pd01 = StringUtils.EMPTY;
    public String pd02 = StringUtils.EMPTY;
    public String pd03 = StringUtils.EMPTY;
    public String pd04 = StringUtils.EMPTY;
    public String pd05 = StringUtils.EMPTY;
    public String pd0596x = StringUtils.EMPTY;
    public String pd06 = StringUtils.EMPTY;
    public String pd06961x = StringUtils.EMPTY;
    public String pd06962x = StringUtils.EMPTY;
    public String pd07 = StringUtils.EMPTY;
    public String pd0701x = StringUtils.EMPTY;
    public String pd08 = StringUtils.EMPTY;
    public String pd09 = StringUtils.EMPTY;
    public String pd10 = StringUtils.EMPTY;
    public String pd1101 = StringUtils.EMPTY;
    public String pd1102 = StringUtils.EMPTY;
    public String pd12 = StringUtils.EMPTY;
    public String pd1296x = StringUtils.EMPTY;
    public String pd13 = StringUtils.EMPTY;
    public String pd13961x = StringUtils.EMPTY;
    public String pd13962x = StringUtils.EMPTY;
    public String pd14 = StringUtils.EMPTY;
    public String pd1496x = StringUtils.EMPTY;
    public String pd15 = StringUtils.EMPTY;
    public String pd16 = StringUtils.EMPTY;
    public String pd1601 = StringUtils.EMPTY;
    public String pd1602 = StringUtils.EMPTY;
    public String pd1603 = StringUtils.EMPTY;
    public String pd1604 = StringUtils.EMPTY;
    public String pd1605 = StringUtils.EMPTY;
    public String pd1606 = StringUtils.EMPTY;
    public String pd1607 = StringUtils.EMPTY;
    public String pd1696 = StringUtils.EMPTY;
    public String pd1696x = StringUtils.EMPTY;
    public String pd17 = StringUtils.EMPTY;
    public String pd1701x = StringUtils.EMPTY;
    public String pd1702x = StringUtils.EMPTY;
    public String pd1703x = StringUtils.EMPTY;
    public String pd18 = StringUtils.EMPTY;
    public String pd19 = StringUtils.EMPTY;
    public String pd20 = StringUtils.EMPTY;
    public String pd2001 = StringUtils.EMPTY;
    public String pd2002 = StringUtils.EMPTY;
    public String pd2003 = StringUtils.EMPTY;
    public String pd2004 = StringUtils.EMPTY;
    public String pd2005 = StringUtils.EMPTY;
    public String pd2006 = StringUtils.EMPTY;
    public String pd2007 = StringUtils.EMPTY;
    public String pd2096 = StringUtils.EMPTY;
    public String pd2096x = StringUtils.EMPTY;
    public String pd21 = StringUtils.EMPTY;
    public String pd2101x = StringUtils.EMPTY;
    public String pd2102x = StringUtils.EMPTY;
    public String pd2103x = StringUtils.EMPTY;
    public String pd22 = StringUtils.EMPTY;
    public String pddate = StringUtils.EMPTY;
    //Section PF
    public String bf01 = StringUtils.EMPTY;
    public String bf02 = StringUtils.EMPTY;
    public String bf03 = StringUtils.EMPTY;
    public String bf3y = StringUtils.EMPTY;
    public String bf03m = StringUtils.EMPTY;
    public String bf3d = StringUtils.EMPTY;
    public String bf03a01 = StringUtils.EMPTY;
    public String bf03a02 = StringUtils.EMPTY;
    public String bf04 = StringUtils.EMPTY;
    public String bf05 = StringUtils.EMPTY;
    public String bf0502x = StringUtils.EMPTY;
    public String bf0503x = StringUtils.EMPTY;
    public String bf06 = StringUtils.EMPTY;
    public String bf07 = StringUtils.EMPTY;
    public String bf0796x = StringUtils.EMPTY;
    public String bf08 = StringUtils.EMPTY;
    public String bf09 = StringUtils.EMPTY;
    public String bf0996x = StringUtils.EMPTY;
    public String bf10 = StringUtils.EMPTY;
    public String bf11 = StringUtils.EMPTY;
    public String bf12 = StringUtils.EMPTY;
    public String bf13 = StringUtils.EMPTY;
    public String bfdate = StringUtils.EMPTY;
    //Section CV
    public String cv01 = StringUtils.EMPTY;
    public String cv02 = StringUtils.EMPTY;
    public String cv03 = StringUtils.EMPTY;
    public String cv04 = StringUtils.EMPTY;
    public String cv0501 = StringUtils.EMPTY;
    public String cv0502 = StringUtils.EMPTY;
    public String cv0503 = StringUtils.EMPTY;
    public String cv0504 = StringUtils.EMPTY;
    public String cv0505 = StringUtils.EMPTY;
    public String cv0506 = StringUtils.EMPTY;
    public String cv0507 = StringUtils.EMPTY;
    public String cv0596 = StringUtils.EMPTY;
    public String cv0596x = StringUtils.EMPTY;
    public String cv0601 = StringUtils.EMPTY;
    public String cv0602 = StringUtils.EMPTY;
    public String cv0603 = StringUtils.EMPTY;
    public String cv0604 = StringUtils.EMPTY;
    public String cv0605 = StringUtils.EMPTY;
    public String cv0606 = StringUtils.EMPTY;
    public String cv0607 = StringUtils.EMPTY;
    public String cv0608 = StringUtils.EMPTY;
    public String cv0609 = StringUtils.EMPTY;
    public String cv0610 = StringUtils.EMPTY;
    public String cv0611 = StringUtils.EMPTY;
    public String cv0696 = StringUtils.EMPTY;
    public String cv0696x = StringUtils.EMPTY;
    public String cv07 = StringUtils.EMPTY;
    public String cv0801 = StringUtils.EMPTY;
    public String cv0802 = StringUtils.EMPTY;
    public String cv0803 = StringUtils.EMPTY;
    public String cv0804 = StringUtils.EMPTY;
    public String cv0805 = StringUtils.EMPTY;
    public String cv0806 = StringUtils.EMPTY;
    public String cv0807 = StringUtils.EMPTY;
    public String cv0896 = StringUtils.EMPTY;
    public String cv0898 = StringUtils.EMPTY;
    public String cv0896x = StringUtils.EMPTY;
    public String cv0901 = StringUtils.EMPTY;
    public String cv0902 = StringUtils.EMPTY;
    public String cv0903 = StringUtils.EMPTY;
    public String cv0904 = StringUtils.EMPTY;
    public String cv0905 = StringUtils.EMPTY;
    public String cv0906 = StringUtils.EMPTY;
    public String cv0907 = StringUtils.EMPTY;
    public String cv0996 = StringUtils.EMPTY;
    public String cv0998 = StringUtils.EMPTY;
    public String cv0996x = StringUtils.EMPTY;
    public String cv1001 = StringUtils.EMPTY;
    public String cv1002 = StringUtils.EMPTY;
    public String cv1003 = StringUtils.EMPTY;
    public String cv1004 = StringUtils.EMPTY;
    public String cv1005 = StringUtils.EMPTY;
    public String cv1006 = StringUtils.EMPTY;
    public String cv1007 = StringUtils.EMPTY;
    public String cv1008 = StringUtils.EMPTY;
    public String cv1096 = StringUtils.EMPTY;
    public String cv1098 = StringUtils.EMPTY;
    public String cv1096x = StringUtils.EMPTY;
    public String cv11 = StringUtils.EMPTY;
    public String cv12 = StringUtils.EMPTY;
    public String cv1296x = StringUtils.EMPTY;
    public String cv13 = StringUtils.EMPTY;
    public String cv14 = StringUtils.EMPTY;
    public String cv15 = StringUtils.EMPTY;
    public String cv16 = StringUtils.EMPTY;
    public String cv1696x = StringUtils.EMPTY;
    public String cv17 = StringUtils.EMPTY;
    public String cv18 = StringUtils.EMPTY;
    public String cv1896x = StringUtils.EMPTY;
    public String cv19 = StringUtils.EMPTY;
    public String cv1996x = StringUtils.EMPTY;
    public String cvdate = StringUtils.EMPTY;
    //Section SE
    public String se01 = StringUtils.EMPTY;
    public String se0196x = StringUtils.EMPTY;
    public String se02 = StringUtils.EMPTY;
    public String se0296x = StringUtils.EMPTY;
    public String se03 = StringUtils.EMPTY;
    public String se0396x = StringUtils.EMPTY;
    public String se04 = StringUtils.EMPTY;
    public String se0496x = StringUtils.EMPTY;
    public String se05 = StringUtils.EMPTY;
    public String se0596x = StringUtils.EMPTY;
    public String se06a = StringUtils.EMPTY;
    public String se07a = StringUtils.EMPTY;
    public String se08 = StringUtils.EMPTY;
    public String se0896x = StringUtils.EMPTY;
    public String se09 = StringUtils.EMPTY;
    public String se10 = StringUtils.EMPTY;
    public String se1099x = StringUtils.EMPTY;
    public String se11 = StringUtils.EMPTY;
    public String se1196x = StringUtils.EMPTY;
    public String se12 = StringUtils.EMPTY;
    public String se1296x = StringUtils.EMPTY;
    public String se13 = StringUtils.EMPTY;
    public String se14 = StringUtils.EMPTY;
    public String se15 = StringUtils.EMPTY;
    public String se16 = StringUtils.EMPTY;
    public String se17 = StringUtils.EMPTY;
    public String se1701 = StringUtils.EMPTY;
    public String se1702 = StringUtils.EMPTY;
    public String se1703 = StringUtils.EMPTY;
    public String se1704 = StringUtils.EMPTY;
    public String se1705 = StringUtils.EMPTY;
    public String se1801 = StringUtils.EMPTY;
    public String se1802 = StringUtils.EMPTY;
    public String se1803 = StringUtils.EMPTY;
    public String se1804 = StringUtils.EMPTY;
    public String se1805 = StringUtils.EMPTY;
    public String se1896 = StringUtils.EMPTY;
    public String se189601x = StringUtils.EMPTY;
    public String se19 = StringUtils.EMPTY;
    public String se1996x = StringUtils.EMPTY;
    public String se20 = StringUtils.EMPTY;
    public String se2001 = StringUtils.EMPTY;
    public String se2002 = StringUtils.EMPTY;
    public String se2003 = StringUtils.EMPTY;
    public String se2004 = StringUtils.EMPTY;
    public String se2005 = StringUtils.EMPTY;
    public String se2006 = StringUtils.EMPTY;
    public String se2096 = StringUtils.EMPTY;
    public String se2096x = StringUtils.EMPTY;
    public String se21 = StringUtils.EMPTY;
    public String se2101 = StringUtils.EMPTY;
    public String se2102 = StringUtils.EMPTY;
    public String se2103 = StringUtils.EMPTY;
    public String se2104 = StringUtils.EMPTY;
    public String se2105 = StringUtils.EMPTY;
    public String se2196 = StringUtils.EMPTY;
    public String se2196x = StringUtils.EMPTY;
    public String se2201 = StringUtils.EMPTY;
    public String se2202 = StringUtils.EMPTY;
    public String se2203 = StringUtils.EMPTY;
    public String se2204 = StringUtils.EMPTY;
    public String se2205 = StringUtils.EMPTY;
    public String se2206 = StringUtils.EMPTY;
    public String se2207 = StringUtils.EMPTY;
    public String se2208 = StringUtils.EMPTY;
    public String se2209 = StringUtils.EMPTY;
    public String se2210 = StringUtils.EMPTY;
    public String se2211 = StringUtils.EMPTY;
    public String se2212 = StringUtils.EMPTY;
    public String se2213 = StringUtils.EMPTY;
    public String se2214 = StringUtils.EMPTY;
    public String se2215 = StringUtils.EMPTY;
    public String se2216 = StringUtils.EMPTY;
    public String se2217 = StringUtils.EMPTY;
    public String se2218 = StringUtils.EMPTY;
    public String se23 = StringUtils.EMPTY;
    public String se24 = StringUtils.EMPTY;
    public String se25 = StringUtils.EMPTY;
    public String se26 = StringUtils.EMPTY;
    public String se27 = StringUtils.EMPTY;
    public String se2701 = StringUtils.EMPTY;
    public String se2702 = StringUtils.EMPTY;
    public String se2703 = StringUtils.EMPTY;
    public String se2704 = StringUtils.EMPTY;
    public String se28 = StringUtils.EMPTY;
    public String se2801 = StringUtils.EMPTY;
    public String se2802 = StringUtils.EMPTY;
    public String se2803 = StringUtils.EMPTY;
    public String se29 = StringUtils.EMPTY;
    public String se30 = StringUtils.EMPTY;
    public String se3001 = StringUtils.EMPTY;
    public String se3002 = StringUtils.EMPTY;
    public String se3003 = StringUtils.EMPTY;
    public String se3096 = StringUtils.EMPTY;
    public String se3096x = StringUtils.EMPTY;
    public String se31 = StringUtils.EMPTY;
    public String se3196x = StringUtils.EMPTY;
    public String se32 = StringUtils.EMPTY;
    public String se3302 = StringUtils.EMPTY;
    public String se3301 = StringUtils.EMPTY;
    public String se3401 = StringUtils.EMPTY;
    public String se3402 = StringUtils.EMPTY;
    public String se35 = StringUtils.EMPTY;
    public String se36 = StringUtils.EMPTY;
    public String se37 = StringUtils.EMPTY;
    public String se3701 = StringUtils.EMPTY;
    public String se3702 = StringUtils.EMPTY;
    public String se3703 = StringUtils.EMPTY;
    public String se3704 = StringUtils.EMPTY;
    public String se3705 = StringUtils.EMPTY;
    public String se3706 = StringUtils.EMPTY;
    public String se3707 = StringUtils.EMPTY;
    public String se3708 = StringUtils.EMPTY;
    public String se3709 = StringUtils.EMPTY;
    public String se3710 = StringUtils.EMPTY;
    public String se3796 = StringUtils.EMPTY;
    public String se3796x = StringUtils.EMPTY;
    public String se38 = StringUtils.EMPTY;
    public String se39 = StringUtils.EMPTY;
    public String se40 = StringUtils.EMPTY;
    public String sedate = StringUtils.EMPTY;

    // APP VARIABLES
    private String id = StringUtils.EMPTY;
    private String uid = StringUtils.EMPTY;
    private String userName = StringUtils.EMPTY;
    private String sysDate = StringUtils.EMPTY;
    private String dcode = StringUtils.EMPTY;
    private String ucode = StringUtils.EMPTY;
    private String cluster = StringUtils.EMPTY;
    private String hhno = StringUtils.EMPTY;
    private String deviceId = StringUtils.EMPTY;
    private String deviceTag = StringUtils.EMPTY;
    private String appver = StringUtils.EMPTY;
    private String gps = StringUtils.EMPTY;
    private String endTime = StringUtils.EMPTY;
    private String iStatus = StringUtils.EMPTY;
    private String iStatus96x = StringUtils.EMPTY;
    private String synced = StringUtils.EMPTY;
    private String syncDate = StringUtils.EMPTY;
    private String g5Flag = "-1";
    // SECTION VARIABLES
    private String s01HH = StringUtils.EMPTY;
    private String s05PD = StringUtils.EMPTY;
    private String s06BF = StringUtils.EMPTY;
    private String s07CV = StringUtils.EMPTY;
    private String s08SE = StringUtils.EMPTY;

    //Not saving in DB
    private LocalDate localDate = null;
    private boolean exist = false;

    public Form() {

    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public void setForm(String userName, String sysDate, String dcode, String ucode, String cluster, String hhno, String deviceId, String deviceTag, String appver, String gps) {
        this.userName = userName;
        this.sysDate = sysDate;
        this.dcode = dcode;
        this.ucode = ucode;
        this.cluster = cluster;
        this.hhno = hhno;
        this.deviceId = deviceId;
        this.deviceTag = deviceTag;
        this.appver = appver;
        this.gps = gps;
    }

    @Bindable
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        if (projectName != projectName)
            this.projectName = projectName;

        //TODO: Update field in layout
        // notifyPropertyChanged(BR.layoutFieldName);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }

    @Bindable
    public String getUid() {
        return uid;
    }

    public Form setUid(String uid) {
        this.uid = uid;
        return this;
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public Form setUserName(String userName) {
        this.userName = userName;
        return this;
    }


    @Bindable
    public String getDcode() {
        return dcode;
    }

    public Form setDcode(String dcode) {
        this.dcode = dcode;
        return this;
    }


    @Bindable
    public String getUcode() {
        return ucode;
    }

    public Form setUcode(String ucode) {
        this.ucode = ucode;
        return this;
    }


    @Bindable
    public String getCluster() {
        return cluster;
    }

    public Form setCluster(String cluster) {
        this.cluster = cluster;
        return this;
    }


    @Bindable
    public String getHhno() {
        return hhno;
    }

    public Form setHhno(String hhno) {
        this.hhno = hhno;
        return this;
    }


    @Bindable
    public String getDeviceId() {
        return deviceId;
    }

    public Form setDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    @Bindable
    public String getDeviceTag() {
        return deviceTag;
    }

    public Form setDeviceTag(String deviceTag) {
        this.deviceTag = deviceTag;
        return this;
    }

    @Bindable
    public String getAppver() {
        return appver;
    }

    public Form setAppver(String appver) {
        this.appver = appver;
        return this;
    }

    @Bindable
    public String getSysDate() {
        return sysDate;
    }

    public Form setSysDate(String sysDate) {
        this.sysDate = sysDate;
        return this;
    }

    @Bindable
    public String getGps() {
        return gps;
    }

    public Form setGps(String gps) {
        this.gps = gps;
        return this;
    }

    @Bindable
    public String getEndTime() {
        return endTime;
    }

    public Form setEndTime(String endTime) {
        this.endTime = endTime;
        return this;
    }


    @Bindable
    public String getSynced() {
        return synced;
    }

    public Form setSynced(String synced) {
        this.synced = synced;
        return this;
    }

    @Bindable
    public String getSyncDate() {
        return syncDate;
    }

    public Form setSyncDate(String syncDate) {
        this.syncDate = syncDate;
        return this;
    }


    public String getG5Flag() {
        return g5Flag;
    }

    public Form setG5Flag(String g5Flag) {
        this.g5Flag = g5Flag;
        return this;
    }


    public String getS01HH() {
        return s01HH;
    }

    public Form setS01HH(String s01HH) {
        this.s01HH = s01HH;
        return this;
    }

    public String getS05PD() {
        return s05PD;
    }

    public Form setS05PD(String s05PD) {
        this.s05PD = s05PD;
        return this;
    }

    public String getS06BF() {
        return s06BF;
    }

    public Form setS06BF(String s06BF) {
        this.s06BF = s06BF;
        return this;
    }

    public String getS07CV() {
        return s07CV;
    }

    public Form setS07CV(String s07CV) {
        this.s07CV = s07CV;
        return this;
    }

    public String getS08SE() {
        return s08SE;
    }

    public Form setS08SE(String s08SE) {
        this.s08SE = s08SE;
        return this;
    }


    @Bindable
    public String getHh01() {
        return hh01;
    }

    public void setHh01(String hh01) {
        this.hh01 = hh01;
        notifyPropertyChanged(BR.hh01);
    }

    @Bindable
    public String getHh0201() {
        return hh0201;
    }

    public void setHh0201(String hh0201) {
        this.hh0201 = hh0201;
        notifyPropertyChanged(BR.hh0201);
    }

    @Bindable
    public String getHh0202() {
        return hh0202;
    }

    public void setHh0202(String hh0202) {
        this.hh0202 = hh0202;
        notifyPropertyChanged(BR.hh0202);
    }

    @Bindable
    public String getHh03() {
        return hh03;
    }

    public void setHh03(String hh03) {
        this.hh03 = hh03;
        notifyPropertyChanged(BR.hh03);
    }

    @Bindable
    public String getHh04() {
        return hh04;
    }

    public void setHh04(String hh04) {
        this.hh04 = hh04;
        notifyPropertyChanged(BR.hh04);
    }

    @Bindable
    public String getHh05() {
        return hh05;
    }

    public void setHh05(String hh05) {
        this.hh05 = hh05;
        notifyPropertyChanged(BR.hh05);
    }

    @Bindable
    public String getHh06() {
        return hh06;
    }

    public void setHh06(String hh06) {
        this.hh06 = hh06;
        notifyPropertyChanged(BR.hh06);
    }

    @Bindable
    public String getHh07() {
        return hh07;
    }

    public void setHh07(String hh07) {
        this.hh07 = hh07;
        notifyPropertyChanged(BR.hh07);
    }

    @Bindable
    public String getHh08() {
        return hh08;
    }

    public void setHh08(String hh08) {
        this.hh08 = hh08;
        notifyPropertyChanged(BR.hh08);
    }

    @Bindable
    public String getHh09() {
        return hh09;
    }

    public void setHh09(String hh09) {
        this.hh09 = hh09;
        notifyPropertyChanged(BR.hh09);
    }

    @Bindable
    public String getHh10() {
        return hh10;
    }

    public void setHh10(String hh10) {
        this.hh10 = hh10;
        notifyPropertyChanged(BR.hh10);
    }

    @Bindable
    public String getHh11() {
        return hh11;
    }

    public void setHh11(String hh11) {
        this.hh11 = hh11;
        setHh12(hh11.equals("2") ? "" : hh12);
        setHh13(hh11.equals("2") ? "" : hh13);
        setHh14(hh11.equals("2") ? "" : hh14);
        setHh15(hh11.equals("2") ? "" : hh15);
        setHh16(hh11.equals("2") ? "" : hh16);
        setHh17(hh11.equals("2") ? "" : hh17);
        setHh18(hh11.equals("2") ? "" : hh18);
        setHh19(hh11.equals("2") ? "" : hh19);
        setHh20(hh11.equals("2") ? "" : hh20);
        setHh21(hh11.equals("2") ? "" : hh21);
        setHh22(hh11.equals("2") ? "" : hh22);
        setHh23(hh11.equals("2") ? "" : hh23);
        setHh24(hh11.equals("2") ? "" : hh24);
        setHh25(hh11.equals("2") ? "" : hh25);
        notifyPropertyChanged(BR.hh11);
    }

    @Bindable
    public String getHh12() {
        return hh12;
    }

    public void setHh12(String hh12) {
        this.hh12 = hh12;
        notifyPropertyChanged(BR.hh12);
    }

    @Bindable
    public String getHh13() {
        return hh13;
    }

    public void setHh13(String hh13) {
        this.hh13 = hh13;
        notifyPropertyChanged(BR.hh13);
    }

    @Bindable
    public String getHh14() {
        return hh14;
    }

    public void setHh14(String hh14) {
        this.hh14 = hh14;
        notifyPropertyChanged(BR.hh14);
    }

    @Bindable
    public String getHh15() {
        return hh15;
    }

    public void setHh15(String hh15) {
        this.hh15 = hh15;
        notifyPropertyChanged(BR.hh15);
    }

    @Bindable
    public String getHh16() {
        return hh16;
    }

    public void setHh16(String hh16) {
        this.hh16 = hh16;
        notifyPropertyChanged(BR.hh16);
    }

    @Bindable
    public String getHh17() {
        return hh17;
    }

    public void setHh17(String hh17) {
        this.hh17 = hh17;
        setHh1796x(hh17.equals("96") ? this.hh1796x : "");
        notifyPropertyChanged(BR.hh17);
    }

    @Bindable
    public String getHh1796x() {
        return hh1796x;
    }

    public void setHh1796x(String hh1796x) {
        this.hh1796x = hh1796x;
        notifyPropertyChanged(BR.hh1796x);
    }

    @Bindable
    public String getHh18() {
        return hh18;
    }

    public void setHh18(String hh18) {
        this.hh18 = hh18;
        notifyPropertyChanged(BR.hh18);
    }

    @Bindable
    public String getHh19() {
        return hh19;
    }

    public void setHh19(String hh19) {
        this.hh19 = hh19;
        notifyPropertyChanged(BR.hh19);
    }

    @Bindable
    public String getHh20() {
        return hh20;
    }

    public void setHh20(String hh20) {
        this.hh20 = hh20;
        setHh2096x(hh20.equals("96") ? this.hh2096x : "");
        notifyPropertyChanged(BR.hh20);
    }

    @Bindable
    public String getHh2096x() {
        return hh2096x;
    }

    public void setHh2096x(String hh2096x) {
        this.hh2096x = hh2096x;
        notifyPropertyChanged(BR.hh2096x);
    }

    @Bindable
    public String getHh21() {
        return hh21;
    }

    public void setHh21(String hh21) {
        this.hh21 = hh21;
        notifyPropertyChanged(BR.hh21);
    }

    @Bindable
    public String getHh22() {
        return hh22;
    }

    public void setHh22(String hh22) {
        this.hh22 = hh22;
        notifyPropertyChanged(BR.hh22);
    }

    @Bindable
    public String getHh23() {
        return hh23;
    }

    public void setHh23(String hh23) {
        this.hh23 = hh23;
        notifyPropertyChanged(BR.hh23);
    }

    @Bindable
    public String getHh24() {
        return hh24;
    }

    public void setHh24(String hh24) {
        this.hh24 = hh24;
        notifyPropertyChanged(BR.hh24);
    }

    @Bindable
    public String getHh25() {
        return hh25;
    }

    public void setHh25(String hh25) {
        this.hh25 = hh25;
        notifyPropertyChanged(BR.hh25);
    }

    @Bindable
    public String getHh26() {
        return hh26;
    }

    public void setHh26(String hh26) {
        this.hh26 = hh26;
        setHh2696x(hh26.equals("96") ? this.hh2696x : "");
        notifyPropertyChanged(BR.hh26);
    }


    @Bindable
    public String getHh2696x() {
        return hh2696x;
    }

    public void setHh2696x(String hh2696x) {
        this.hh2696x = hh2696x;
        notifyPropertyChanged(BR.hh2696x);
    }


    @Bindable
    public String getPd01() {
        return pd01;
    }

    public void setPd01(String pd01) {
        this.pd01 = pd01;
        notifyPropertyChanged(BR.pd01);
    }

    @Bindable
    public String getPd02() {
        return pd02;
    }

    public void setPd02(String pd02) {
        this.pd02 = pd02;
        notifyPropertyChanged(BR.pd02);
    }

    @Bindable
    public String getPd03() {
        return pd03;
    }

    public void setPd03(String pd03) {
        this.pd03 = pd03;
        notifyPropertyChanged(BR.pd03);
    }

    @Bindable
    public String getPd04() {
        return pd04;
    }

    public void setPd04(String pd04) {
        this.pd04 = pd04;
        notifyPropertyChanged(BR.pd04);
    }

    @Bindable
    public String getPd05() {
        return pd05;
    }

    public void setPd05(String pd05) {
        this.pd05 = pd05;
        setPd0596x(pd05.equals("96") ? this.pd0596x : "");
        notifyPropertyChanged(BR.pd05);
    }

    @Bindable
    public String getPd0596x() {
        return pd0596x;
    }

    public void setPd0596x(String pd0596x) {
        this.pd0596x = pd0596x;
        notifyPropertyChanged(BR.pd0596x);
    }

    @Bindable
    public String getPd06() {
        return pd06;
    }

    public void setPd06(String pd06) {
        this.pd06 = pd06;
        setPd06961x(pd06.equals("961") ? this.pd06961x : "");
        setPd06962x(pd06.equals("962") ? this.pd06962x : "");
        notifyPropertyChanged(BR.pd06);
    }

    @Bindable
    public String getPd06961x() {
        return pd06961x;
    }

    public void setPd06961x(String pd06961x) {
        this.pd06961x = pd06961x;
        notifyPropertyChanged(BR.pd06961x);
    }

    @Bindable
    public String getPd06962x() {
        return pd06962x;
    }

    public void setPd06962x(String pd06962x) {
        this.pd06962x = pd06962x;
        notifyPropertyChanged(BR.pd06962x);
    }

    @Bindable
    public String getPd07() {
        return pd07;
    }

    public void setPd07(String pd07) {
        this.pd07 = pd07;
        setPd0701x(pd07.equals("1") ? this.pd0701x : "");
        notifyPropertyChanged(BR.pd07);
    }

    @Bindable
    public String getPd0701x() {
        return pd0701x;
    }

    public void setPd0701x(String pd0701x) {
        this.pd0701x = pd0701x;
        notifyPropertyChanged(BR.pd0701x);
    }

    @Bindable
    public String getPd08() {
        return pd08;
    }

    public void setPd08(String pd08) {
        this.pd08 = pd08;
        notifyPropertyChanged(BR.pd08);
    }

    @Bindable
    public String getPd09() {
        return pd09;
    }

    public void setPd09(String pd09) {
        this.pd09 = pd09;
        notifyPropertyChanged(BR.pd09);
    }

    @Bindable
    public String getPd10() {
        return pd10;
    }

    public void setPd10(String pd10) {
        this.pd10 = pd10;
        notifyPropertyChanged(BR.pd10);
    }

    @Bindable
    public String getPd1101() {
        return pd1101;
    }

    public void setPd1101(String pd1101) {
        this.pd1101 = pd1101;
        notifyPropertyChanged(BR.pd1101);
    }

    @Bindable
    public String getPd1102() {
        return pd1102;
    }

    public void setPd1102(String pd1102) {
        this.pd1102 = pd1102;
        notifyPropertyChanged(BR.pd1102);
    }

    @Bindable
    public String getPd12() {
        return pd12;
    }

    public void setPd12(String pd12) {
        this.pd12 = pd12;
        setPd1296x(pd12.equals("96") ? this.pd1296x : "");
        notifyPropertyChanged(BR.pd12);
    }

    @Bindable
    public String getPd1296x() {
        return pd1296x;
    }

    public void setPd1296x(String pd1296x) {
        this.pd1296x = pd1296x;
        notifyPropertyChanged(BR.pd1296x);
    }

    @Bindable
    public String getPd13() {
        return pd13;
    }

    public void setPd13(String pd13) {
        this.pd13 = pd13;
        setPd13961x(pd13.equals("961") ? this.pd13961x : "");
        setPd13962x(pd13.equals("962") ? this.pd13962x : "");
        notifyPropertyChanged(BR.pd13);
    }

    @Bindable
    public String getPd13961x() {
        return pd13961x;
    }

    public void setPd13961x(String pd13961x) {
        this.pd13961x = pd13961x;
        notifyPropertyChanged(BR.pd13961x);
    }

    @Bindable
    public String getPd13962x() {
        return pd13962x;
    }

    public void setPd13962x(String pd13962x) {
        this.pd13962x = pd13962x;
        notifyPropertyChanged(BR.pd13962x);
    }

    @Bindable
    public String getPd14() {
        return pd14;
    }

    public void setPd14(String pd14) {
        this.pd14 = pd14;
        setPd1496x(pd14.equals("96") ? this.pd1496x : "");
        notifyPropertyChanged(BR.pd14);
    }

    @Bindable
    public String getPd1496x() {
        return pd1496x;
    }

    public void setPd1496x(String pd1496x) {
        this.pd1496x = pd1496x;
        notifyPropertyChanged(BR.pd1496x);
    }

    @Bindable
    public String getPd15() {
        return pd15;
    }

    public void setPd15(String pd15) {
        this.pd15 = pd15;
        notifyPropertyChanged(BR.pd15);
    }

    @Bindable
    public String getPd16() {
        return pd16;
    }

    public void setPd16(String pd16) {
        this.pd16 = pd16;
        notifyPropertyChanged(BR.pd16);
    }

    @Bindable
    public String getPd1601() {
        return pd1601;
    }

    public void setPd1601(String pd1601) {
        if (this.pd1601.equals(pd1601)) return;
        this.pd1601 = pd1601;
        notifyPropertyChanged(BR.pd1601);
    }

    @Bindable
    public String getPd1602() {
        return pd1602;
    }

    public void setPd1602(String pd1602) {
        if (this.pd1602.equals(pd1602)) return;
        this.pd1602 = pd1602;
        notifyPropertyChanged(BR.pd1602);
    }

    @Bindable
    public String getPd1603() {
        return pd1603;
    }

    public void setPd1603(String pd1603) {
        if (this.pd1603.equals(pd1603)) return;
        this.pd1603 = pd1603;
        notifyPropertyChanged(BR.pd1603);
    }

    @Bindable
    public String getPd1604() {
        return pd1604;
    }

    public void setPd1604(String pd1604) {
        if (this.pd1604.equals(pd1604)) return;
        this.pd1604 = pd1604;
        notifyPropertyChanged(BR.pd1604);
    }

    @Bindable
    public String getPd1605() {
        return pd1605;
    }

    public void setPd1605(String pd1605) {
        if (this.pd1605.equals(pd1605)) return;
        this.pd1605 = pd1605;
        notifyPropertyChanged(BR.pd1605);
    }

    @Bindable
    public String getPd1606() {
        return pd1606;
    }

    public void setPd1606(String pd1606) {
        if (this.pd1606.equals(pd1606)) return;
        this.pd1606 = pd1606;
        notifyPropertyChanged(BR.pd1606);
    }

    @Bindable
    public String getPd1607() {
        return pd1607;
    }

    public void setPd1607(String pd1607) {
        if (this.pd1607.equals(pd1607)) return;
        this.pd1607 = pd1607;
        notifyPropertyChanged(BR.pd1607);
    }

    @Bindable
    public String getPd1696() {
        return pd1696;
    }

    public void setPd1696(String pd1696) {
        if (this.pd1696.equals(pd1696)) return;
        this.pd1696 = pd1696;
        setPd1696x(pd1696.equals("96") ? this.pd1696x : "");
        notifyPropertyChanged(BR.pd1696);
    }

    @Bindable
    public String getPd1696x() {
        return pd1696x;
    }

    public void setPd1696x(String pd1696x) {
        this.pd1696x = pd1696x;
        notifyPropertyChanged(BR.pd1696x);
    }

    @Bindable
    public String getPd17() {
        return pd17;
    }

    public void setPd17(String pd17) {
        this.pd17 = pd17;
        notifyPropertyChanged(BR.pd17);
    }

    @Bindable
    public String getPd1701x() {
        return pd1701x;
    }

    public void setPd1701x(String pd1701x) {
        this.pd1701x = pd1701x;
        notifyPropertyChanged(BR.pd1701x);
    }

    @Bindable
    public String getPd1702x() {
        return pd1702x;
    }

    public void setPd1702x(String pd1702x) {
        this.pd1702x = pd1702x;
        notifyPropertyChanged(BR.pd1702x);
    }

    @Bindable
    public String getPd1703x() {
        return pd1703x;
    }

    public void setPd1703x(String pd1703x) {
        this.pd1703x = pd1703x;
        notifyPropertyChanged(BR.pd1703x);
    }

    @Bindable
    public String getPd18() {
        return pd18;
    }

    public void setPd18(String pd18) {
        this.pd18 = pd18;
        notifyPropertyChanged(BR.pd18);
    }

    @Bindable
    public String getPd19() {
        return pd19;
    }

    public void setPd19(String pd19) {
        this.pd19 = pd19;
        notifyPropertyChanged(BR.pd19);
    }

    @Bindable
    public String getPd20() {
        return pd20;
    }

    public void setPd20(String pd20) {
        this.pd20 = pd20;
        notifyPropertyChanged(BR.pd20);
    }

    @Bindable
    public String getPd2001() {
        return pd2001;
    }

    public void setPd2001(String pd2001) {
        this.pd2001 = pd2001;
        notifyPropertyChanged(BR.pd2001);
    }


    @Bindable
    public String getPd2002() {
        return pd2002;
    }

    public void setPd2002(String pd2002) {
        this.pd2002 = pd2002;
        notifyPropertyChanged(BR.pd2002);
    }

    @Bindable
    public String getPd2003() {
        return pd2003;
    }

    public void setPd2003(String pd2003) {
        this.pd2003 = pd2003;
        notifyPropertyChanged(BR.pd2003);
    }

    @Bindable
    public String getPd2004() {
        return pd2004;
    }

    public void setPd2004(String pd2004) {
        this.pd2004 = pd2004;
        notifyPropertyChanged(BR.pd2004);
    }

    @Bindable
    public String getPd2005() {
        return pd2005;
    }

    public void setPd2005(String pd2005) {
        this.pd2005 = pd2005;
        notifyPropertyChanged(BR.pd2005);
    }

    @Bindable
    public String getPd2006() {
        return pd2006;
    }

    public void setPd2006(String pd2006) {
        this.pd2006 = pd2006;
        notifyPropertyChanged(BR.pd2006);
    }

    @Bindable
    public String getPd2007() {
        return pd2007;
    }

    public void setPd2007(String pd2007) {
        this.pd2007 = pd2007;
        notifyPropertyChanged(BR.pd2007);
    }

    @Bindable
    public String getPd2096() {
        return pd2096;
    }

    public void setPd2096(String pd2096) {
        this.pd2096 = pd2096;
        notifyPropertyChanged(BR.pd2096);
    }

    @Bindable
    public String getPd2096x() {
        return pd2096x;
    }

    public void setPd2096x(String pd2096x) {
        this.pd2096x = pd2096x;
        notifyPropertyChanged(BR.pd2096x);
    }

    @Bindable
    public String getPd21() {
        return pd21;
    }

    public void setPd21(String pd21) {
        this.pd21 = pd21;
        notifyPropertyChanged(BR.pd21);
    }

    @Bindable
    public String getPd2101x() {
        return pd2101x;
    }

    public void setPd2101x(String pd2101x) {
        this.pd2101x = pd2101x;
        notifyPropertyChanged(BR.pd2101x);
    }

    @Bindable
    public String getPd2102x() {
        return pd2102x;
    }

    public void setPd2102x(String pd2102x) {
        this.pd2102x = pd2102x;
        notifyPropertyChanged(BR.pd2102x);
    }

    @Bindable
    public String getPd2103x() {
        return pd2103x;
    }

    public void setPd2103x(String pd2103x) {
        this.pd2103x = pd2103x;
        notifyPropertyChanged(BR.pd2103x);
    }

    @Bindable
    public String getPd22() {
        return pd22;
    }

    public void setPd22(String pd22) {
        this.pd22 = pd22;
        notifyPropertyChanged(BR.pd22);
    }

    @Bindable
    public String getBf01() {
        return bf01;
    }

    public void setBf01(String bf01) {
        this.bf01 = bf01;
        notifyPropertyChanged(BR.bf01);
    }

    @Bindable
    public String getBf02() {
        return bf02;
    }

    public void setBf02(String bf02) {
        this.bf02 = bf02;
        notifyPropertyChanged(BR.bf02);
    }

    @Bindable
    public String getBf03() {
        return bf03;
    }

    public void setBf03(String bf03) {
        this.bf03 = bf03;
        notifyPropertyChanged(BR.bf03);
    }

    @Bindable
    public String getBf3y() {
        return bf3y;
    }

    public void setBf3y(String bf3y) {
        this.bf3y = bf3y;
        notifyPropertyChanged(BR.bf3y);
    }

    @Bindable
    public String getBf03m() {
        return bf03m;
    }

    public void setBf03m(String bf03m) {
        this.bf03m = bf03m;
        notifyPropertyChanged(BR.bf03m);
    }

    @Bindable
    public String getBf3d() {
        return bf3d;
    }

    public void setBf3d(String bf3d) {
        this.bf3d = bf3d;
        notifyPropertyChanged(BR.bf3d);
    }


    @Bindable
    public String getBf03a01() {
        return bf03a01;
    }

    public void setBf03a01(String bf03a01) {
        this.bf03a01 = bf03a01;
        notifyPropertyChanged(BR.bf03a01);
    }


    @Bindable
    public String getBf03a02() {
        return bf03a02;
    }

    public void setBf03a02(String bf03a02) {
        this.bf03a02 = bf03a02;
        notifyPropertyChanged(BR.bf03a02);
    }


    @Bindable
    public String getBf04() {
        return bf04;
    }

    public void setBf04(String bf04) {
        this.bf04 = bf04;
        notifyPropertyChanged(BR.bf04);
    }

    @Bindable
    public String getBf05() {
        return bf05;
    }

    public void setBf05(String bf05) {
        this.bf05 = bf05;
        notifyPropertyChanged(BR.bf05);
    }

    @Bindable
    public String getBf0502x() {
        return bf0502x;
    }

    public void setBf0502x(String bf0502x) {
        this.bf0502x = bf0502x;
        notifyPropertyChanged(BR.bf0502x);
    }

    @Bindable
    public String getBf0503x() {
        return bf0503x;
    }

    public void setBf0503x(String bf0503x) {
        this.bf0503x = bf0503x;
        notifyPropertyChanged(BR.bf0503x);
    }

    @Bindable
    public String getBf06() {
        return bf06;
    }

    public void setBf06(String bf06) {
        this.bf06 = bf06;
        notifyPropertyChanged(BR.bf06);
    }

    @Bindable
    public String getBf07() {
        return bf07;
    }

    public void setBf07(String bf07) {
        this.bf07 = bf07;
        notifyPropertyChanged(BR.bf07);
    }

    @Bindable
    public String getBf0796x() {
        return bf0796x;
    }

    public void setBf0796x(String bf0796x) {
        this.bf0796x = bf0796x;
        notifyPropertyChanged(BR.bf0796x);
    }

    @Bindable
    public String getBf08() {
        return bf08;
    }

    public void setBf08(String bf08) {
        this.bf08 = bf08;
        notifyPropertyChanged(BR.bf08);
    }

    @Bindable
    public String getBf09() {
        return bf09;
    }

    public void setBf09(String bf09) {
        this.bf09 = bf09;
        notifyPropertyChanged(BR.bf09);
    }

    @Bindable
    public String getBf0996x() {
        return bf0996x;
    }

    public void setBf0996x(String bf0996x) {
        this.bf0996x = bf0996x;
        notifyPropertyChanged(BR.bf0996x);
    }

    @Bindable
    public String getBf10() {
        return bf10;
    }

    public void setBf10(String bf10) {
        this.bf10 = bf10;
        notifyPropertyChanged(BR.bf10);
    }

    @Bindable
    public String getBf11() {
        return bf11;
    }

    public void setBf11(String bf11) {
        this.bf11 = bf11;
        notifyPropertyChanged(BR.bf11);
    }

    @Bindable
    public String getBf12() {
        return bf12;
    }

    public void setBf12(String bf12) {
        this.bf12 = bf12;
        notifyPropertyChanged(BR.bf12);
    }

    @Bindable
    public String getBf13() {
        return bf13;
    }

    public void setBf13(String bf13) {
        this.bf13 = bf13;
        notifyPropertyChanged(BR.bf13);
    }

    @Bindable
    public String getCv01() {
        return cv01;
    }

    public void setCv01(String cv01) {
        this.cv01 = cv01;
        notifyPropertyChanged(BR.cv01);
    }

    @Bindable
    public String getCv02() {
        return cv02;
    }

    public void setCv02(String cv02) {
        this.cv02 = cv02;
        notifyPropertyChanged(BR.cv02);
    }

    @Bindable
    public String getCv03() {
        return cv03;
    }

    public void setCv03(String cv03) {
        this.cv03 = cv03;
        notifyPropertyChanged(BR.cv03);
    }

    @Bindable
    public String getCv04() {
        return cv04;
    }

    public void setCv04(String cv04) {
        this.cv04 = cv04;
        notifyPropertyChanged(BR.cv04);
    }


    @Bindable
    public String getCv0501() {
        return cv0501;
    }

    public void setCv0501(String cv0501) {
        this.cv0501 = cv0501;
        notifyPropertyChanged(BR.cv0501);
    }


    @Bindable
    public String getCv0502() {
        return cv0502;
    }

    public void setCv0502(String cv0502) {
        this.cv0502 = cv0502;
        notifyPropertyChanged(BR.cv0502);
    }


    @Bindable
    public String getCv0503() {
        return cv0503;
    }

    public void setCv0503(String cv0503) {
        this.cv0503 = cv0503;
        notifyPropertyChanged(BR.cv0503);
    }


    @Bindable
    public String getCv0504() {
        return cv0504;
    }

    public void setCv0504(String cv0504) {
        this.cv0504 = cv0504;
        notifyPropertyChanged(BR.cv0504);
    }


    @Bindable
    public String getCv0505() {
        return cv0505;
    }

    public void setCv0505(String cv0505) {
        this.cv0505 = cv0505;
        notifyPropertyChanged(BR.cv0505);
    }


    @Bindable
    public String getCv0506() {
        return cv0506;
    }

    public void setCv0506(String cv0506) {
        this.cv0506 = cv0506;
        notifyPropertyChanged(BR.cv0506);
    }


    @Bindable
    public String getCv0507() {
        return cv0507;
    }

    public void setCv0507(String cv0507) {
        this.cv0507 = cv0507;
        notifyPropertyChanged(BR.cv0507);
    }


    @Bindable
    public String getCv0596() {
        return cv0596;
    }

    public void setCv0596(String cv0596) {
        this.cv0596 = cv0596;
        notifyPropertyChanged(BR.cv0596);
    }


    @Bindable
    public String getCv0596x() {
        return cv0596x;
    }

    public void setCv0596x(String cv0596x) {
        this.cv0596x = cv0596x;
        notifyPropertyChanged(BR.cv0596x);
    }


    @Bindable
    public String getCv0601() {
        return cv0601;
    }

    public void setCv0601(String cv0601) {
        this.cv0601 = cv0601;
        notifyPropertyChanged(BR.cv0601);
    }


    @Bindable
    public String getCv0602() {
        return cv0602;
    }

    public void setCv0602(String cv0602) {
        this.cv0602 = cv0602;
        notifyPropertyChanged(BR.cv0602);
    }


    @Bindable
    public String getCv0603() {
        return cv0603;
    }

    public void setCv0603(String cv0603) {
        this.cv0603 = cv0603;
        notifyPropertyChanged(BR.cv0603);
    }


    @Bindable
    public String getCv0604() {
        return cv0604;
    }

    public void setCv0604(String cv0604) {
        this.cv0604 = cv0604;
        notifyPropertyChanged(BR.cv0604);
    }


    @Bindable
    public String getCv0605() {
        return cv0605;
    }

    public void setCv0605(String cv0605) {
        this.cv0605 = cv0605;
        notifyPropertyChanged(BR.cv0605);
    }


    @Bindable
    public String getCv0606() {
        return cv0606;
    }

    public void setCv0606(String cv0606) {
        this.cv0606 = cv0606;
        notifyPropertyChanged(BR.cv0606);
    }


    @Bindable
    public String getCv0607() {
        return cv0607;
    }

    public void setCv0607(String cv0607) {
        this.cv0607 = cv0607;
        notifyPropertyChanged(BR.cv0607);
    }


    @Bindable
    public String getCv0608() {
        return cv0608;
    }

    public void setCv0608(String cv0608) {
        this.cv0608 = cv0608;
        notifyPropertyChanged(BR.cv0608);
    }


    @Bindable
    public String getCv0609() {
        return cv0609;
    }

    public void setCv0609(String cv0609) {
        this.cv0609 = cv0609;
        notifyPropertyChanged(BR.cv0609);
    }


    @Bindable
    public String getCv0610() {
        return cv0610;
    }

    public void setCv0610(String cv0610) {
        this.cv0610 = cv0610;
        notifyPropertyChanged(BR.cv0610);
    }


    @Bindable
    public String getCv0611() {
        return cv0611;
    }

    public void setCv0611(String cv0611) {
        this.cv0611 = cv0611;
        notifyPropertyChanged(BR.cv0611);
    }


    @Bindable
    public String getCv0696() {
        return cv0696;
    }

    public void setCv0696(String cv0696) {
        this.cv0696 = cv0696;
        notifyPropertyChanged(BR.cv0696);
    }


    @Bindable
    public String getCv0696x() {
        return cv0696x;
    }

    public void setCv0696x(String cv0696x) {
        this.cv0696x = cv0696x;
        notifyPropertyChanged(BR.cv0696x);
    }


    @Bindable
    public String getCv07() {
        return cv07;
    }

    public void setCv07(String cv07) {
        this.cv07 = cv07;
        notifyPropertyChanged(BR.cv07);
    }


    @Bindable
    public String getCv0801() {
        return cv0801;
    }

    public void setCv0801(String cv0801) {
        this.cv0801 = cv0801;
        notifyPropertyChanged(BR.cv0801);
    }


    @Bindable
    public String getCv0802() {
        return cv0802;
    }

    public void setCv0802(String cv0802) {
        this.cv0802 = cv0802;
        notifyPropertyChanged(BR.cv0802);
    }


    @Bindable
    public String getCv0803() {
        return cv0803;
    }

    public void setCv0803(String cv0803) {
        this.cv0803 = cv0803;
        notifyPropertyChanged(BR.cv0803);
    }


    @Bindable
    public String getCv0804() {
        return cv0804;
    }

    public void setCv0804(String cv0804) {
        this.cv0804 = cv0804;
        notifyPropertyChanged(BR.cv0804);
    }


    @Bindable
    public String getCv0805() {
        return cv0805;
    }

    public void setCv0805(String cv0805) {
        this.cv0805 = cv0805;
        notifyPropertyChanged(BR.cv0805);
    }


    @Bindable
    public String getCv0806() {
        return cv0806;
    }

    public void setCv0806(String cv0806) {
        this.cv0806 = cv0806;
        notifyPropertyChanged(BR.cv0806);
    }


    @Bindable
    public String getCv0807() {
        return cv0807;
    }

    public void setCv0807(String cv0807) {
        this.cv0807 = cv0807;
        notifyPropertyChanged(BR.cv0807);
    }


    @Bindable
    public String getCv0896() {
        return cv0896;
    }

    public void setCv0896(String cv0896) {
        this.cv0896 = cv0896;
        notifyPropertyChanged(BR.cv0896);
    }


    @Bindable
    public String getCv0898() {
        return cv0898;
    }

    public void setCv0898(String cv0898) {
        this.cv0898 = cv0898;
        notifyPropertyChanged(BR.cv0898);
    }


    @Bindable
    public String getCv0896x() {
        return cv0896x;
    }

    public void setCv0896x(String cv0896x) {
        this.cv0896x = cv0896x;
        notifyPropertyChanged(BR.cv0896x);
    }


    @Bindable
    public String getCv0901() {
        return cv0901;
    }

    public void setCv0901(String cv0901) {
        this.cv0901 = cv0901;
        notifyPropertyChanged(BR.cv0901);
    }


    @Bindable
    public String getCv0902() {
        return cv0902;
    }

    public void setCv0902(String cv0902) {
        this.cv0902 = cv0902;
        notifyPropertyChanged(BR.cv0902);
    }


    @Bindable
    public String getCv0903() {
        return cv0903;
    }

    public void setCv0903(String cv0903) {
        this.cv0903 = cv0903;
        notifyPropertyChanged(BR.cv0903);
    }


    @Bindable
    public String getCv0904() {
        return cv0904;
    }

    public void setCv0904(String cv0904) {
        this.cv0904 = cv0904;
        notifyPropertyChanged(BR.cv0904);
    }


    @Bindable
    public String getCv0905() {
        return cv0905;
    }

    public void setCv0905(String cv0905) {
        this.cv0905 = cv0905;
        notifyPropertyChanged(BR.cv0905);
    }


    @Bindable
    public String getCv0906() {
        return cv0906;
    }

    public void setCv0906(String cv0906) {
        this.cv0906 = cv0906;
        notifyPropertyChanged(BR.cv0906);
    }


    @Bindable
    public String getCv0907() {
        return cv0907;
    }

    public void setCv0907(String cv0907) {
        this.cv0907 = cv0907;
        notifyPropertyChanged(BR.cv0907);
    }


    @Bindable
    public String getCv0996() {
        return cv0996;
    }

    public void setCv0996(String cv0996) {
        this.cv0996 = cv0996;
        notifyPropertyChanged(BR.cv0996);
    }


    @Bindable
    public String getCv0998() {
        return cv0998;
    }

    public void setCv0998(String cv0998) {
        this.cv0998 = cv0998;
        notifyPropertyChanged(BR.cv0998);
    }


    @Bindable
    public String getCv0996x() {
        return cv0996x;
    }

    public void setCv0996x(String cv0996x) {
        this.cv0996x = cv0996x;
        notifyPropertyChanged(BR.cv0996x);
    }


    @Bindable
    public String getCv1001() {
        return cv1001;
    }

    public void setCv1001(String cv1001) {
        this.cv1001 = cv1001;
        notifyPropertyChanged(BR.cv1001);
    }


    @Bindable
    public String getCv1002() {
        return cv1002;
    }

    public void setCv1002(String cv1002) {
        this.cv1002 = cv1002;
        notifyPropertyChanged(BR.cv1002);
    }


    @Bindable
    public String getCv1003() {
        return cv1003;
    }

    public void setCv1003(String cv1003) {
        this.cv1003 = cv1003;
        notifyPropertyChanged(BR.cv1003);
    }


    @Bindable
    public String getCv1004() {
        return cv1004;
    }

    public void setCv1004(String cv1004) {
        this.cv1004 = cv1004;
        notifyPropertyChanged(BR.cv1004);
    }


    @Bindable
    public String getCv1005() {
        return cv1005;
    }

    public void setCv1005(String cv1005) {
        this.cv1005 = cv1005;
        notifyPropertyChanged(BR.cv1005);
    }


    @Bindable
    public String getCv1006() {
        return cv1006;
    }

    public void setCv1006(String cv1006) {
        this.cv1006 = cv1006;
        notifyPropertyChanged(BR.cv1006);
    }


    @Bindable
    public String getCv1007() {
        return cv1007;
    }

    public void setCv1007(String cv1007) {
        this.cv1007 = cv1007;
        notifyPropertyChanged(BR.cv1007);
    }


    @Bindable
    public String getCv1008() {
        return cv1008;
    }

    public void setCv1008(String cv1008) {
        this.cv1008 = cv1008;
        notifyPropertyChanged(BR.cv1008);
    }


    @Bindable
    public String getCv1096() {
        return cv1096;
    }

    public void setCv1096(String cv1096) {
        this.cv1096 = cv1096;
        notifyPropertyChanged(BR.cv1096);
    }


    @Bindable
    public String getCv1098() {
        return cv1098;
    }

    public void setCv1098(String cv1098) {
        this.cv1098 = cv1098;
        notifyPropertyChanged(BR.cv1098);
    }


    @Bindable
    public String getCv1096x() {
        return cv1096x;
    }

    public void setCv1096x(String cv1096x) {
        this.cv1096x = cv1096x;
        notifyPropertyChanged(BR.cv1096x);
    }


    @Bindable
    public String getCv11() {
        return cv11;
    }

    public void setCv11(String cv11) {
        this.cv11 = cv11;
        notifyPropertyChanged(BR.cv11);
    }

    @Bindable
    public String getCv12() {
        return cv12;
    }

    public void setCv12(String cv12) {
        this.cv12 = cv12;
        notifyPropertyChanged(BR.cv12);
    }

    @Bindable
    public String getCv1296x() {
        return cv1296x;
    }

    public void setCv1296x(String cv1296x) {
        this.cv1296x = cv1296x;
        notifyPropertyChanged(BR.cv1296x);
    }

    @Bindable
    public String getCv13() {
        return cv13;
    }

    public void setCv13(String cv13) {
        this.cv13 = cv13;
        notifyPropertyChanged(BR.cv13);
    }

    @Bindable
    public String getCv14() {
        return cv14;
    }

    public void setCv14(String cv14) {
        this.cv14 = cv14;
        notifyPropertyChanged(BR.cv14);
    }

    @Bindable
    public String getCv15() {
        return cv15;
    }

    public void setCv15(String cv15) {
        this.cv15 = cv15;
        notifyPropertyChanged(BR.cv15);
    }

    @Bindable
    public String getCv16() {
        return cv16;
    }

    public void setCv16(String cv16) {
        this.cv16 = cv16;
        notifyPropertyChanged(BR.cv16);
    }

    @Bindable
    public String getCv1696x() {
        return cv1696x;
    }

    public void setCv1696x(String cv1696x) {
        this.cv1696x = cv1696x;
        notifyPropertyChanged(BR.cv1696x);
    }

    @Bindable
    public String getCv17() {
        return cv17;
    }

    public void setCv17(String cv17) {
        this.cv17 = cv17;
        notifyPropertyChanged(BR.cv17);
    }

    @Bindable
    public String getCv18() {
        return cv18;
    }

    public void setCv18(String cv18) {
        this.cv18 = cv18;
        notifyPropertyChanged(BR.cv18);
    }

    @Bindable
    public String getCv1896x() {
        return cv1896x;
    }

    public void setCv1896x(String cv1896x) {
        this.cv1896x = cv1896x;
        notifyPropertyChanged(BR.cv1896x);
    }

    @Bindable
    public String getCv19() {
        return cv19;
    }

    public void setCv19(String cv19) {
        this.cv19 = cv19;
        notifyPropertyChanged(BR.cv19);
    }

    @Bindable
    public String getCv1996x() {
        return cv1996x;
    }

    public void setCv1996x(String cv1996x) {
        this.cv1996x = cv1996x;
        notifyPropertyChanged(BR.cv1996x);
    }


    @Bindable
    public String getSe01() {
        return se01;
    }

    public void setSe01(String se01) {
        this.se01 = se01;
        notifyPropertyChanged(BR.se01);
    }

    @Bindable
    public String getSe0196x() {
        return se0196x;
    }

    public void setSe0196x(String se0196x) {
        this.se0196x = se0196x;
        notifyPropertyChanged(BR.se0196x);
    }

    @Bindable
    public String getSe02() {
        return se02;
    }

    public void setSe02(String se02) {
        this.se02 = se02;
        notifyPropertyChanged(BR.se02);
    }

    @Bindable
    public String getSe0296x() {
        return se0296x;
    }

    public void setSe0296x(String se0296x) {
        this.se0296x = se0296x;
        notifyPropertyChanged(BR.se0296x);
    }

    @Bindable
    public String getSe03() {
        return se03;
    }

    public void setSe03(String se03) {
        this.se03 = se03;
        notifyPropertyChanged(BR.se03);
    }

    @Bindable
    public String getSe0396x() {
        return se0396x;
    }

    public void setSe0396x(String se0396x) {
        this.se0396x = se0396x;
        notifyPropertyChanged(BR.se0396x);
    }

    @Bindable
    public String getSe04() {
        return se04;
    }

    public void setSe04(String se04) {
        this.se04 = se04;
        notifyPropertyChanged(BR.se04);
    }

    @Bindable
    public String getSe0496x() {
        return se0496x;
    }

    public void setSe0496x(String se0496x) {
        this.se0496x = se0496x;
        notifyPropertyChanged(BR.se0496x);
    }

    @Bindable
    public String getSe05() {
        return se05;
    }

    public void setSe05(String se05) {
        this.se05 = se05;
        notifyPropertyChanged(BR.se05);
    }

    @Bindable
    public String getSe0596x() {
        return se0596x;
    }

    public void setSe0596x(String se0596x) {
        this.se0596x = se0596x;
        notifyPropertyChanged(BR.se0596x);
    }

    @Bindable
    public String getSe06a() {
        return se06a;
    }

    public void setSe06a(String se06a) {
        this.se06a = se06a;
        notifyPropertyChanged(BR.se06a);
    }

    @Bindable
    public String getSe07a() {
        return se07a;
    }

    public void setSe07a(String se07a) {
        this.se07a = se07a;
        notifyPropertyChanged(BR.se07a);
    }

    @Bindable
    public String getSe08() {
        return se08;
    }

    public void setSe08(String se08) {
        this.se08 = se08;
        notifyPropertyChanged(BR.se08);
    }

    @Bindable
    public String getSe0896x() {
        return se0896x;
    }

    public void setSe0896x(String se0896x) {
        this.se0896x = se0896x;
        notifyPropertyChanged(BR.se0896x);
    }

    @Bindable
    public String getSe09() {
        return se09;
    }

    public void setSe09(String se09) {
        this.se09 = se09;
        notifyPropertyChanged(BR.se09);
    }

    @Bindable
    public String getSe10() {
        return se10;
    }

    public void setSe10(String se10) {
        this.se10 = se10;
        notifyPropertyChanged(BR.se10);
    }

    @Bindable
    public String getSe1099x() {
        return se1099x;
    }

    public void setSe1099x(String se1099x) {
        this.se1099x = se1099x;
        notifyPropertyChanged(BR.se1099x);
    }

    @Bindable
    public String getSe11() {
        return se11;
    }

    public void setSe11(String se11) {
        this.se11 = se11;
        notifyPropertyChanged(BR.se11);
    }

    @Bindable
    public String getSe1196x() {
        return se1196x;
    }

    public void setSe1196x(String se1196x) {
        this.se1196x = se1196x;
        notifyPropertyChanged(BR.se1196x);
    }

    @Bindable
    public String getSe12() {
        return se12;
    }

    public void setSe12(String se12) {
        this.se12 = se12;
        notifyPropertyChanged(BR.se12);
    }

    @Bindable
    public String getSe1296x() {
        return se1296x;
    }

    public void setSe1296x(String se1296x) {
        this.se1296x = se1296x;
        notifyPropertyChanged(BR.se1296x);
    }

    @Bindable
    public String getSe13() {
        return se13;
    }

    public void setSe13(String se13) {
        this.se13 = se13;
        notifyPropertyChanged(BR.se13);
    }

    @Bindable
    public String getSe14() {
        return se14;
    }

    public void setSe14(String se14) {
        this.se14 = se14;
        notifyPropertyChanged(BR.se14);
    }

    @Bindable
    public String getSe15() {
        return se15;
    }

    public void setSe15(String se15) {
        this.se15 = se15;
        notifyPropertyChanged(BR.se15);
    }

    @Bindable
    public String getSe16() {
        return se16;
    }

    public void setSe16(String se16) {
        this.se16 = se16;
        notifyPropertyChanged(BR.se16);
    }

    @Bindable
    public String getSe17() {
        return se17;
    }

    public void setSe17(String se17) {
        this.se17 = se17;
        notifyPropertyChanged(BR.se17);
    }

    @Bindable
    public String getSe1701() {
        return se1701;
    }

    public void setSe1701(String se1701) {
        this.se1701 = se1701;
        notifyPropertyChanged(BR.se1701);
    }

    @Bindable
    public String getSe1702() {
        return se1702;
    }

    public void setSe1702(String se1702) {
        this.se1702 = se1702;
        notifyPropertyChanged(BR.se1702);
    }

    @Bindable
    public String getSe1703() {
        return se1703;
    }

    public void setSe1703(String se1703) {
        this.se1703 = se1703;
        notifyPropertyChanged(BR.se1703);
    }

    @Bindable
    public String getSe1704() {
        return se1704;
    }

    public void setSe1704(String se1704) {
        this.se1704 = se1704;
        notifyPropertyChanged(BR.se1704);
    }

    @Bindable
    public String getSe1705() {
        return se1705;
    }

    public void setSe1705(String se1705) {
        this.se1705 = se1705;
        notifyPropertyChanged(BR.se1705);
    }

    @Bindable
    public String getSe1801() {
        return se1801;
    }

    public void setSe1801(String se1801) {
        this.se1801 = se1801;
        notifyPropertyChanged(BR.se1801);
    }

    @Bindable
    public String getSe1802() {
        return se1802;
    }

    public void setSe1802(String se1802) {
        this.se1802 = se1802;
        notifyPropertyChanged(BR.se1802);
    }

    @Bindable
    public String getSe1803() {
        return se1803;
    }

    public void setSe1803(String se1803) {
        this.se1803 = se1803;
        notifyPropertyChanged(BR.se1803);
    }

    @Bindable
    public String getSe1804() {
        return se1804;
    }

    public void setSe1804(String se1804) {
        this.se1804 = se1804;
        notifyPropertyChanged(BR.se1804);
    }

    @Bindable
    public String getSe1805() {
        return se1805;
    }

    public void setSe1805(String se1805) {
        this.se1805 = se1805;
        notifyPropertyChanged(BR.se1805);
    }

    @Bindable
    public String getSe1896() {
        return se1896;
    }

    public void setSe1896(String se1896) {
        this.se1896 = se1896;
        notifyPropertyChanged(BR.se1896);
    }

    @Bindable
    public String getSe189601x() {
        return se189601x;
    }

    public void setSe189601x(String se189601x) {
        this.se189601x = se189601x;
        notifyPropertyChanged(BR.se189601x);
    }

    @Bindable
    public String getSe19() {
        return se19;
    }

    public void setSe19(String se19) {
        this.se19 = se19;
        notifyPropertyChanged(BR.se19);
    }

    @Bindable
    public String getSe1996x() {
        return se1996x;
    }

    public void setSe1996x(String se1996x) {
        this.se1996x = se1996x;
        notifyPropertyChanged(BR.se1996x);
    }

    @Bindable
    public String getSe2001() {
        return se2001;
    }

    public void setSe2001(String se2001) {
        this.se2001 = se2001;
        notifyPropertyChanged(BR.se2001);
    }

    @Bindable
    public String getSe2002() {
        return se2002;
    }

    public void setSe2002(String se2002) {
        this.se2002 = se2002;
        notifyPropertyChanged(BR.se2002);
    }

    @Bindable
    public String getSe2003() {
        return se2003;
    }

    public void setSe2003(String se2003) {
        this.se2003 = se2003;
        notifyPropertyChanged(BR.se2003);
    }

    @Bindable
    public String getSe2004() {
        return se2004;
    }

    public void setSe2004(String se2004) {
        this.se2004 = se2004;
        notifyPropertyChanged(BR.se2004);
    }


    @Bindable
    public String getSe2005() {
        return se2005;
    }

    public void setSe2005(String se2005) {
        this.se2005 = se2005;
        notifyPropertyChanged(BR.se2005);
    }


    @Bindable
    public String getSe2006() {
        return se2006;
    }

    public void setSe2006(String se2006) {
        this.se2006 = se2006;
        notifyPropertyChanged(BR.se2006);
    }


    @Bindable
    public String getSe2096() {
        Log.d(TAG, "getSe2096: " + this.se2096);
        return se2096;
    }

    public void setSe2096(String se2096) {
        if (this.se2096 != se2096) {
            this.se2096 = se2096;
            Log.d(TAG, "setSe2096: " + this.se2096);
            notifyPropertyChanged(BR.se2096);
        }
    }
    
  /*  if (this.a303 != a303) {
        this.a303 = a303;
        notifyPropertyChanged(BR.a303);
        Log.d(TAG, "setA303: " + this.a303);
    }*/

    @Bindable
    public String getSe2096x() {
        return se2096x;
    }

    public void setSe2096x(String se2096x) {
        this.se2096x = se2096x;
        notifyPropertyChanged(BR.se2096x);
    }

    @Bindable
    public String getSe21() {
        return se21;
    }

    public void setSe21(String se21) {
        this.se21 = se21;
        notifyPropertyChanged(BR.se21);
    }

    @Bindable
    public String getSe2101() {
        return se2101;
    }

    public void setSe2101(String se2101) {
        this.se2101 = se2101;
        notifyPropertyChanged(BR.se2101);
    }

    @Bindable
    public String getSe2102() {
        return se2102;
    }

    public void setSe2102(String se2102) {
        this.se2102 = se2102;
        notifyPropertyChanged(BR.se2102);
    }

    @Bindable
    public String getSe2103() {
        return se2103;
    }

    public void setSe2103(String se2103) {
        this.se2103 = se2103;
        notifyPropertyChanged(BR.se2103);
    }

    @Bindable
    public String getSe2104() {
        return se2104;
    }

    public void setSe2104(String se2104) {
        this.se2104 = se2104;
        notifyPropertyChanged(BR.se2104);
    }

    @Bindable
    public String getSe2105() {
        return se2105;
    }

    public void setSe2105(String se2105) {
        this.se2105 = se2105;
        notifyPropertyChanged(BR.se2105);
    }

    @Bindable
    public String getSe2196() {
        return se2196;
    }

    public void setSe2196(String se2196) {
        this.se2196 = se2196;
        notifyPropertyChanged(BR.se2196);
    }

    @Bindable
    public String getSe2196x() {
        return se2196x;
    }

    public void setSe2196x(String se2196x) {
        this.se2196x = se2196x;
        notifyPropertyChanged(BR.se2196x);
    }

    @Bindable
    public String getSe2201() {
        return se2201;
    }

    public void setSe2201(String se2201) {
        this.se2201 = se2201;
        notifyPropertyChanged(BR.se2201);
    }

    @Bindable
    public String getSe2202() {
        return se2202;
    }

    public void setSe2202(String se2202) {
        this.se2202 = se2202;
        notifyPropertyChanged(BR.se2202);
    }

    @Bindable
    public String getSe2203() {
        return se2203;
    }

    public void setSe2203(String se2203) {
        this.se2203 = se2203;
        notifyPropertyChanged(BR.se2203);
    }

    @Bindable
    public String getSe2204() {
        return se2204;
    }

    public void setSe2204(String se2204) {
        this.se2204 = se2204;
        notifyPropertyChanged(BR.se2204);
    }

    @Bindable
    public String getSe2205() {
        return se2205;
    }

    public void setSe2205(String se2205) {
        this.se2205 = se2205;
        notifyPropertyChanged(BR.se2205);
    }

    @Bindable
    public String getSe2206() {
        return se2206;
    }

    public void setSe2206(String se2206) {
        this.se2206 = se2206;
        notifyPropertyChanged(BR.se2206);
    }

    @Bindable
    public String getSe2207() {
        return se2207;
    }

    public void setSe2207(String se2207) {
        this.se2207 = se2207;
        notifyPropertyChanged(BR.se2207);
    }

    @Bindable
    public String getSe2208() {
        return se2208;
    }

    public void setSe2208(String se2208) {
        this.se2208 = se2208;
        notifyPropertyChanged(BR.se2208);
    }

    @Bindable
    public String getSe2209() {
        return se2209;
    }

    public void setSe2209(String se2209) {
        this.se2209 = se2209;
        notifyPropertyChanged(BR.se2209);
    }

    @Bindable
    public String getSe2210() {
        return se2210;
    }

    public void setSe2210(String se2210) {
        this.se2210 = se2210;
        notifyPropertyChanged(BR.se2210);
    }

    @Bindable
    public String getSe2211() {
        return se2211;
    }

    public void setSe2211(String se2211) {
        this.se2211 = se2211;
        notifyPropertyChanged(BR.se2211);
    }

    @Bindable
    public String getSe2212() {
        return se2212;
    }

    public void setSe2212(String se2212) {
        this.se2212 = se2212;
        notifyPropertyChanged(BR.se2212);
    }

    @Bindable
    public String getSe2213() {
        return se2213;
    }

    public void setSe2213(String se2213) {
        this.se2213 = se2213;
        notifyPropertyChanged(BR.se2213);
    }

    @Bindable
    public String getSe2214() {
        return se2214;
    }

    public void setSe2214(String se2214) {
        this.se2214 = se2214;
        notifyPropertyChanged(BR.se2214);
    }

    @Bindable
    public String getSe2215() {
        return se2215;
    }

    public void setSe2215(String se2215) {
        this.se2215 = se2215;
        notifyPropertyChanged(BR.se2215);
    }

    @Bindable
    public String getSe2216() {
        return se2216;
    }

    public void setSe2216(String se2216) {
        this.se2216 = se2216;
        notifyPropertyChanged(BR.se2216);
    }

    @Bindable
    public String getSe2217() {
        return se2217;
    }

    public void setSe2217(String se2217) {
        this.se2217 = se2217;
        notifyPropertyChanged(BR.se2217);
    }

    @Bindable
    public String getSe2218() {
        return se2218;
    }

    public void setSe2218(String se2218) {
        this.se2218 = se2218;
        notifyPropertyChanged(BR.se2218);
    }

    @Bindable
    public String getSe23() {
        return se23;
    }

    public void setSe23(String se23) {
        this.se23 = se23;
        notifyPropertyChanged(BR.se23);
    }

    @Bindable
    public String getSe24() {
        return se24;
    }

    public void setSe24(String se24) {
        this.se24 = se24;
        notifyPropertyChanged(BR.se24);
    }

    @Bindable
    public String getSe25() {
        return se25;
    }

    public void setSe25(String se25) {
        this.se25 = se25;
        notifyPropertyChanged(BR.se25);
    }

    @Bindable
    public String getSe26() {
        return se26;
    }

    public void setSe26(String se26) {
        this.se26 = se26;
        notifyPropertyChanged(BR.se26);
    }

    @Bindable
    public String getSe27() {
        return se27;
    }

    public void setSe27(String se27) {
        this.se27 = se27;
        notifyPropertyChanged(BR.se27);
    }

    @Bindable
    public String getSe2701() {
        return se2701;
    }

    public void setSe2701(String se2701) {
        this.se2701 = se2701;
        notifyPropertyChanged(BR.se2701);
    }

    @Bindable
    public String getSe2702() {
        return se2702;
    }

    public void setSe2702(String se2702) {
        this.se2702 = se2702;
        notifyPropertyChanged(BR.se2702);
    }

    @Bindable
    public String getSe2703() {
        return se2703;
    }

    public void setSe2703(String se2703) {
        this.se2703 = se2703;
        notifyPropertyChanged(BR.se2703);
    }

    @Bindable
    public String getSe2704() {
        return se2704;
    }

    public void setSe2704(String se2704) {
        this.se2704 = se2704;
        notifyPropertyChanged(BR.se2704);
    }

    @Bindable
    public String getSe28() {
        return se28;
    }

    public void setSe28(String se28) {
        this.se28 = se28;
        notifyPropertyChanged(BR.se28);
    }

    @Bindable
    public String getSe2801() {
        return se2801;
    }

    public void setSe2801(String se2801) {
        this.se2801 = se2801;
        notifyPropertyChanged(BR.se2801);
    }

    @Bindable
    public String getSe2802() {
        return se2802;
    }

    public void setSe2802(String se2802) {
        this.se2802 = se2802;
        notifyPropertyChanged(BR.se2802);
    }

    @Bindable
    public String getSe2803() {
        return se2803;
    }

    public void setSe2803(String se2803) {
        this.se2803 = se2803;
        notifyPropertyChanged(BR.se2803);
    }

    @Bindable
    public String getSe29() {
        return se29;
    }

    public void setSe29(String se29) {
        this.se29 = se29;
        notifyPropertyChanged(BR.se29);
    }

    @Bindable
    public String getSe30() {
        return se30;
    }

    public void setSe30(String se30) {
        this.se30 = se30;
        notifyPropertyChanged(BR.se30);
    }

    @Bindable
    public String getSe3001() {
        return se3001;
    }

    public void setSe3001(String se3001) {
        this.se3001 = se3001;
        notifyPropertyChanged(BR.se3001);
    }

    @Bindable
    public String getSe3002() {
        return se3002;
    }

    public void setSe3002(String se3002) {
        this.se3002 = se3002;
        notifyPropertyChanged(BR.se3002);
    }

    @Bindable
    public String getSe3003() {
        return se3003;
    }

    public void setSe3003(String se3003) {
        this.se3003 = se3003;
        notifyPropertyChanged(BR.se3003);
    }

    @Bindable
    public String getSe3096() {
        return se3096;
    }

    public void setSe3096(String se3096) {
        this.se3096 = se3096;
        notifyPropertyChanged(BR.se3096);
    }

    @Bindable
    public String getSe3096x() {
        return se3096x;
    }

    public void setSe3096x(String se3096x) {
        this.se3096x = se3096x;
        notifyPropertyChanged(BR.se3096x);
    }

    @Bindable
    public String getSe31() {
        return se31;
    }

    public void setSe31(String se31) {
        this.se31 = se31;
        notifyPropertyChanged(BR.se31);
    }

    @Bindable
    public String getSe3196x() {
        return se3196x;
    }

    public void setSe3196x(String se3196x) {
        this.se3196x = se3196x;
        notifyPropertyChanged(BR.se3196x);
    }

    @Bindable
    public String getSe32() {
        return se32;
    }

    public void setSe32(String se32) {
        this.se32 = se32;
        notifyPropertyChanged(BR.se32);
    }

    @Bindable
    public String getSe3302() {
        return se3302;
    }

    public void setSe3302(String se3302) {
        this.se3302 = se3302;
        notifyPropertyChanged(BR.se3302);
    }

    @Bindable
    public String getSe3301() {
        return se3301;
    }

    public void setSe3301(String se3301) {
        this.se3301 = se3301;
        notifyPropertyChanged(BR.se3301);
    }

    @Bindable
    public String getSe3401() {
        return se3401;
    }

    public void setSe3401(String se3401) {
        this.se3401 = se3401;
        notifyPropertyChanged(BR.se3401);
    }

    @Bindable
    public String getSe3402() {
        return se3402;
    }

    public void setSe3402(String se3402) {
        this.se3402 = se3402;
        notifyPropertyChanged(BR.se3402);
    }

    @Bindable
    public String getSe35() {
        return se35;
    }

    public void setSe35(String se35) {
        this.se35 = se35;
        notifyPropertyChanged(BR.se35);
    }

    @Bindable
    public String getSe36() {
        return se36;
    }

    public void setSe36(String se36) {
        this.se36 = se36;
        notifyPropertyChanged(BR.se36);
    }

    @Bindable
    public String getSe37() {
        return se37;
    }

    public void setSe37(String se37) {
        this.se37 = se37;
        notifyPropertyChanged(BR.se37);
    }

    @Bindable
    public String getSe3701() {
        return se3701;
    }

    public void setSe3701(String se3701) {
        this.se3701 = se3701;
        notifyPropertyChanged(BR.se3701);
    }

    @Bindable
    public String getSe3702() {
        return se3702;
    }

    public void setSe3702(String se3702) {
        this.se3702 = se3702;
        notifyPropertyChanged(BR.se3702);
    }

    @Bindable
    public String getSe3703() {
        return se3703;
    }

    public void setSe3703(String se3703) {
        this.se3703 = se3703;
        notifyPropertyChanged(BR.se3703);
    }

    @Bindable
    public String getSe3704() {
        return se3704;
    }

    public void setSe3704(String se3704) {
        this.se3704 = se3704;
        notifyPropertyChanged(BR.se3704);
    }

    @Bindable
    public String getSe3705() {
        return se3705;
    }

    public void setSe3705(String se3705) {
        this.se3705 = se3705;
        notifyPropertyChanged(BR.se3705);
    }

    @Bindable
    public String getSe3706() {
        return se3706;
    }

    public void setSe3706(String se3706) {
        this.se3706 = se3706;
        notifyPropertyChanged(BR.se3706);
    }

    @Bindable
    public String getSe3707() {
        return se3707;
    }

    public void setSe3707(String se3707) {
        this.se3707 = se3707;
        notifyPropertyChanged(BR.se3707);
    }

    @Bindable
    public String getSe3708() {
        return se3708;
    }

    public void setSe3708(String se3708) {
        this.se3708 = se3708;
        notifyPropertyChanged(BR.se3708);
    }


    @Bindable
    public String getSe3709() {
        return se3709;
    }

    public void setSe3709(String se3709) {
        this.se3709 = se3709;
        notifyPropertyChanged(BR.se3709);
    }


    @Bindable
    public String getSe3710() {
        return se3710;
    }

    public void setSe3710(String se3710) {
        this.se3710 = se3710;
        notifyPropertyChanged(BR.se3710);
    }


    @Bindable
    public String getSe3796() {
        return se3796;
    }

    public void setSe3796(String se3796) {
        this.se3796 = se3796;
        notifyPropertyChanged(BR.se3796);
    }

    @Bindable
    public String getSe3796x() {
        return se3796x;
    }

    public void setSe3796x(String se3796x) {
        this.se3796x = se3796x;
        notifyPropertyChanged(BR.se3796x);
    }

    @Bindable
    public String getSe38() {
        return se38;
    }

    public void setSe38(String se38) {
        this.se38 = se38;
        notifyPropertyChanged(BR.se38);
    }

    @Bindable
    public String getSe39() {
        return se39;
    }

    public void setSe39(String se39) {
        this.se39 = se39;
        notifyPropertyChanged(BR.se39);
    }

    @Bindable
    public String getSe40() {
        return se40;
    }

    public void setSe40(String se40) {
        this.se40 = se40;
        notifyPropertyChanged(BR.se40);
    }


    @Bindable
    public String getPddate() {
        return pddate;
    }

    public void setPddate(String pddate) {
        this.pddate = pddate;
        notifyPropertyChanged(BR.pddate);
    }


    @Bindable
    public String getBfdate() {
        return bfdate;
    }

    public void setBfdate(String bfdate) {
        this.bfdate = bfdate;
        notifyPropertyChanged(BR.bfdate);
    }


    @Bindable
    public String getCvdate() {
        return cvdate;
    }

    public void setCvdate(String cvdate) {
        this.cvdate = cvdate;
        notifyPropertyChanged(BR.cvdate);
    }


    @Bindable
    public String getSedate() {
        return sedate;
    }

    public void setSedate(String sedate) {
        this.sedate = sedate;
        notifyPropertyChanged(BR.sedate);
    }


    @Bindable
    public String getIStatus() {
        return iStatus;
    }

    public void setIStatus(String iStatus) {
        this.iStatus = iStatus;
        notifyPropertyChanged(BR.iStatus);
    }

    @Bindable
    public String getIStatus96x() {
        return iStatus96x;
    }

    public void setIStatus96x(String iStatus96x) {
        this.iStatus96x = iStatus96x;
        notifyPropertyChanged(BR.iStatus96x);
    }


    public Form Sync(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getString(FormsContract.FormsTable.COLUMN_ID);
        this.uid = jsonObject.getString(FormsContract.FormsTable.COLUMN_UID);
        this.userName = jsonObject.getString(FormsContract.FormsTable.COLUMN_USERNAME);
        this.sysDate = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYSDATE);
        this.dcode = jsonObject.getString(FormsContract.FormsTable.COLUMN_DCODE);
        this.ucode = jsonObject.getString(FormsContract.FormsTable.COLUMN_UCODE);
        this.cluster = jsonObject.getString(FormsContract.FormsTable.COLUMN_CLUSTER);
        this.hhno = jsonObject.getString(FormsContract.FormsTable.COLUMN_HHNO);
        this.deviceId = jsonObject.getString(FormsContract.FormsTable.COLUMN_DEVICEID);
        this.deviceTag = jsonObject.getString(FormsContract.FormsTable.COLUMN_DEVICETAGID);
        this.appver = jsonObject.getString(FormsContract.FormsTable.COLUMN_APPVERSION);
        this.gps = jsonObject.getString(FormsContract.FormsTable.COLUMN_GPS);
        this.endTime = jsonObject.getString(FormsContract.FormsTable.COLUMN_ENDINGDATETIME);
        this.iStatus = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS);
        this.iStatus96x = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS96x);
        this.iStatus96x = jsonObject.getString(FormsContract.FormsTable.COLUMN_ISTATUS96x);
        this.synced = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYNCED);
        this.syncDate = jsonObject.getString(FormsContract.FormsTable.COLUMN_SYNCED_DATE);
        this.g5Flag = jsonObject.getString(FormsContract.FormsTable.COLUMN_G5FLAG);

        this.s01HH = jsonObject.getString(FormsContract.FormsTable.COLUMN_S01HH);
        this.s05PD = jsonObject.getString(FormsContract.FormsTable.COLUMN_S05PD);
        this.s06BF = jsonObject.getString(FormsContract.FormsTable.COLUMN_S06BF);
        this.s07CV = jsonObject.getString(FormsContract.FormsTable.COLUMN_S07CV);
        this.s08SE = jsonObject.getString(FormsContract.FormsTable.COLUMN_S08SE);

        return this;

    }


    public Form Hydrate(Cursor cursor) {
        this.id = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ID));
        this.uid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UID));
        this.userName = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_USERNAME));
        this.sysDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYSDATE));
        this.dcode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DCODE));
        this.ucode = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_UCODE));
        this.cluster = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_CLUSTER));
        this.hhno = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_HHNO));
        this.deviceId = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DEVICEID));
        this.deviceTag = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_DEVICETAGID));
        this.appver = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_APPVERSION));
        this.gps = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_GPS));
        this.endTime = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ENDINGDATETIME));
        this.iStatus = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS));
        this.iStatus96x = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_ISTATUS96x));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED));
        this.syncDate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SYNCED_DATE));
        this.g5Flag = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_G5FLAG));

        //For childCount
        //this.s01HH = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S01HH));

        s01HHHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S01HH)));
        s05PDHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S05PD)));
        s06BFHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S06BF)));
        s07CVHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S07CV)));
        s08SEHydrate(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_S08SE)));

        return this;
    }


    //TODO: Try this instead of toJSONObject
    @Override
    public String toString() {
        return new GsonBuilder().create().toJson(this, Form.class);
    }


    public String s01HHtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("hh01", hh01)
                    .put("hh01", hh01)
                    .put("hh0201", hh0201)
                    .put("hh0202", hh0202)
                    .put("hh03", hh03)
                    .put("hh04", hh04)
                    .put("hh05", hh05)
                    .put("hh06", hh06)
                    .put("hh07", hh07)
                    .put("hh08", hh08)
                    .put("hh09", hh09)
                    .put("hh10", hh10)
                    .put("hh11", hh11)
                    .put("hh12", hh12)
                    .put("hh13", hh13)
                    .put("hh14", hh14)
                    .put("hh15", hh15)
                    .put("hh16", hh16)
                    .put("hh17", hh17)
                    .put("hh1796x", hh1796x)
                    .put("hh18", hh18)
                    .put("hh19", hh19)
                    .put("hh20", hh20)
                    .put("hh2096x", hh2096x)
                    .put("hh21", hh21)
                    .put("hh22", hh22)
                    .put("hh23", hh23)
                    .put("hh24", hh24)
                    .put("hh25", hh25)
                    .put("hh26", hh26)
                    .put("hh2696x", hh2696x);
        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";
        }
        return json.toString();
    }


    public String s05PDtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("pd01", pd01)
                    .put("pd02", pd02)
                    .put("pd03", pd03)
                    .put("pd04", pd04)
                    .put("pd05", pd05)
                    .put("pd0596x", pd0596x)
                    .put("pd06", pd06)
                    .put("pd06961x", pd06961x)
                    .put("pd06962x", pd06962x)
                    .put("pd07", pd07)
                    .put("pd0701x", pd0701x)
                    .put("pd08", pd08)
                    .put("pd09", pd09)
                    .put("pd10", pd10)
                    .put("pd1101", pd1101)
                    .put("pd1102", pd1102)
                    .put("pd12", pd12)
                    .put("pd1296x", pd1296x)
                    .put("pd13", pd13)
                    .put("pd13961x", pd13961x)
                    .put("pd13962x", pd13962x)
                    .put("pd14", pd14)
                    .put("pd1496x", pd1496x)
                    .put("pd15", pd15)
                    .put("pd16", pd16)
                    .put("pd1601", pd1601)
                    .put("pd1602", pd1602)
                    .put("pd1603", pd1603)
                    .put("pd1604", pd1604)
                    .put("pd1605", pd1605)
                    .put("pd1606", pd1606)
                    .put("pd1607", pd1607)
                    .put("pd1696", pd1696)
                    .put("pd1696x", pd1696x)
                    .put("pd17", pd17)
                    .put("pd1701x", pd1701x)
                    .put("pd1702x", pd1702x)
                    .put("pd1703x", pd1703x)
                    .put("pd18", pd18)
                    .put("pd19", pd19)
                    .put("pd20", pd20)
                    .put("pd2001", pd2001)
                    .put("pd2002", pd2002)
                    .put("pd2003", pd2003)
                    .put("pd2004", pd2004)
                    .put("pd2005", pd2005)
                    .put("pd2006", pd2006)
                    .put("pd2007", pd2007)
                    .put("pd2096", pd2096)
                    .put("pd2096x", pd2096x)
                    .put("pd21", pd21)
                    .put("pd2101x", pd2101x)
                    .put("pd2102x", pd2102x)
                    .put("pd2103x", pd2103x)
                    .put("pd22", pd22)
                    .put("pddate", pddate);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public String s06BFtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("bf01", bf01)
                    .put("bf02", bf02)
                    .put("bf03", bf03)
                    .put("bf3y", bf3y)
                    .put("bf03m", bf03m)
                    .put("bf3d", bf3d)
                    .put("bf03a01", bf03a01)
                    .put("bf03a02", bf03a02)
                    .put("bf04", bf04)
                    .put("bf05", bf05)
                    .put("bf0502x", bf0502x)
                    .put("bf0503x", bf0503x)
                    .put("bf06", bf06)
                    .put("bf07", bf07)
                    .put("bf0796x", bf0796x)
                    .put("bf08", bf08)
                    .put("bf09", bf09)
                    .put("bf0996x", bf0996x)
                    .put("bf10", bf10)
                    .put("bf11", bf11)
                    .put("bf12", bf12)
                    .put("bf13", bf13)
                    .put("bfdate", bfdate);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public String s07CVtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("cv01", cv01)
                    .put("cv02", cv02)
                    .put("cv03", cv03)
                    .put("cv04", cv04)
                    .put("cv0501", cv0501)
                    .put("cv0502", cv0502)
                    .put("cv0503", cv0503)
                    .put("cv0504", cv0504)
                    .put("cv0505", cv0505)
                    .put("cv0506", cv0506)
                    .put("cv0507", cv0507)
                    .put("cv0596", cv0596)
                    .put("cv0596x", cv0596x)
                    .put("cv0601", cv0601)
                    .put("cv0602", cv0602)
                    .put("cv0603", cv0603)
                    .put("cv0604", cv0604)
                    .put("cv0605", cv0605)
                    .put("cv0606", cv0606)
                    .put("cv0607", cv0607)
                    .put("cv0608", cv0608)
                    .put("cv0609", cv0609)
                    .put("cv0610", cv0610)
                    .put("cv0611", cv0611)
                    .put("cv0696", cv0696)
                    .put("cv0696x", cv0696x)
                    .put("cv07", cv07)
                    .put("cv0801", cv0801)
                    .put("cv0802", cv0802)
                    .put("cv0803", cv0803)
                    .put("cv0804", cv0804)
                    .put("cv0805", cv0805)
                    .put("cv0806", cv0806)
                    .put("cv0807", cv0807)
                    .put("cv0898", cv0898)
                    .put("cv0896", cv0896)
                    .put("cv0896x", cv0896x)
                    .put("cv0901", cv0901)
                    .put("cv0902", cv0902)
                    .put("cv0903", cv0903)
                    .put("cv0904", cv0904)
                    .put("cv0905", cv0905)
                    .put("cv0906", cv0906)
                    .put("cv0907", cv0907)
                    .put("cv0998", cv0998)
                    .put("cv0996", cv0996)
                    .put("cv0996x", cv0996x)
                    .put("cv1001", cv1001)
                    .put("cv1002", cv1002)
                    .put("cv1003", cv1003)
                    .put("cv1004", cv1004)
                    .put("cv1005", cv1005)
                    .put("cv1006", cv1006)
                    .put("cv1007", cv1007)
                    .put("cv1008", cv1008)
                    .put("cv1098", cv1098)
                    .put("cv1096", cv1096)
                    .put("cv1096x", cv1096x)
                    .put("cv11", cv11)
                    .put("cv12", cv12)
                    .put("cv1296x", cv1296x)
                    .put("cv13", cv13)
                    .put("cv14", cv14)
                    .put("cv15", cv15)
                    .put("cv16", cv16)
                    .put("cv1696x", cv1696x)
                    .put("cv17", cv17)
                    .put("cv18", cv18)
                    .put("cv1896x", cv1896x)
                    .put("cv19", cv19)
                    .put("cv1996x", cv1996x)
                    .put("cvdate", cvdate);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public String s08SEtoString() {
        JSONObject json = new JSONObject();

        try {
            json.put("se01", se01)
                    .put("se0196x", se0196x)
                    .put("se02", se02)
                    .put("se0296x", se0296x)
                    .put("se03", se03)
                    .put("se0396x", se0396x)
                    .put("se04", se04)
                    .put("se0496x", se0496x)
                    .put("se05", se05)
                    .put("se0596x", se0596x)
                    .put("se06a", se06a)
                    .put("se07a", se07a)
                    .put("se08", se08)
                    .put("se0896x", se0896x)
                    .put("se09", se09)
                    .put("se10", se10)
                    .put("se1099x", se1099x)
                    .put("se11", se11)
                    .put("se1196x", se1196x)
                    .put("se12", se12)
                    .put("se1296x", se1296x)
                    .put("se13", se13)
                    .put("se14", se14)
                    .put("se15", se15)
                    .put("se16", se16)
                    .put("se17", se17)
                    .put("se1701", se1701)
                    .put("se1702", se1702)
                    .put("se1703", se1703)
                    .put("se1704", se1704)
                    .put("se1705", se1705)
                    .put("se1801", se1801)
                    .put("se1802", se1802)
                    .put("se1803", se1803)
                    .put("se1804", se1804)
                    .put("se1805", se1805)
                    .put("se1896", se1896)
                    .put("se189601x", se189601x)
                    .put("se19", se19)
                    .put("se1996x", se1996x)
                    .put("se2001", se2001)
                    .put("se2002", se2002)
                    .put("se2003", se2003)
                    .put("se2004", se2004)
                    .put("se2005", se2005)
                    .put("se2006", se2006)
                    .put("se2096", se2096)
                    .put("se2096x", se2096x)
                    .put("se2101", se2101)
                    .put("se2102", se2102)
                    .put("se2103", se2103)
                    .put("se2104", se2104)
                    .put("se2105", se2105)
                    .put("se2196", se2196)
                    .put("se2196x", se2196x)
                    .put("se2201", se2201)
                    .put("se2202", se2202)
                    .put("se2203", se2203)
                    .put("se2204", se2204)
                    .put("se2205", se2205)
                    .put("se2206", se2206)
                    .put("se2207", se2207)
                    .put("se2208", se2208)
                    .put("se2209", se2209)
                    .put("se2210", se2210)
                    .put("se2211", se2211)
                    .put("se2212", se2212)
                    .put("se2213", se2213)
                    .put("se2214", se2214)
                    .put("se2215", se2215)
                    .put("se2216", se2216)
                    .put("se2217", se2217)
                    .put("se2218", se2218)
                    .put("se23", se23)
                    .put("se24", se24)
                    .put("se25", se25)
                    .put("se26", se26)
                    .put("se27", se27)
                    .put("se2701", se2701)
                    .put("se2702", se2702)
                    .put("se2703", se2703)
                    .put("se2704", se2704)
                    .put("se28", se28)
                    .put("se2801", se2801)
                    .put("se2802", se2802)
                    .put("se2803", se2803)
                    .put("se29", se29)
                    .put("se30", se30)
                    .put("se3001", se3001)
                    .put("se3002", se3002)
                    .put("se3003", se3003)
                    .put("se3096", se3096)
                    .put("se3096x", se3096x)
                    .put("se31", se31)
                    .put("se3196x", se3196x)
                    .put("se32", se32)
                    .put("se3302", se3302)
                    .put("se3301", se3301)
                    .put("se3401", se3401)
                    .put("se3402", se3402)
                    .put("se35", se35)
                    .put("se36", se36)
                    .put("se37", se37)
                    .put("se3701", se3701)
                    .put("se3702", se3702)
                    .put("se3703", se3703)
                    .put("se3704", se3704)
                    .put("se3705", se3705)
                    .put("se3706", se3706)
                    .put("se3707", se3707)
                    .put("se3708", se3708)
                    .put("se3709", se3709)
                    .put("se3710", se3710)
                    .put("se3796", se3796)
                    .put("se3796x", se3796x)
                    .put("se38", se38)
                    .put("se39", se39)
                    .put("se40", se40)
                    .put("sedate", sedate);

        } catch (JSONException e) {
            e.printStackTrace();
            return "\"error\":, \"" + e.getMessage() + "\"";

        }
        return json.toString();
    }


    public JSONObject toJSONObject() {

        JSONObject json = new JSONObject();

        try {
            json.put(FormsContract.FormsTable.COLUMN_ID, this.id == null ? JSONObject.NULL : this.id);
            json.put(FormsContract.FormsTable.COLUMN_UID, this.uid == null ? JSONObject.NULL : this.uid);
            json.put(FormsContract.FormsTable.COLUMN_USERNAME, this.userName == null ? JSONObject.NULL : this.userName);
            json.put(FormsContract.FormsTable.COLUMN_SYSDATE, this.sysDate == null ? JSONObject.NULL : this.sysDate);
            json.put(FormsContract.FormsTable.COLUMN_DCODE, this.dcode == null ? JSONObject.NULL : this.dcode);
            json.put(FormsContract.FormsTable.COLUMN_UCODE, this.ucode == null ? JSONObject.NULL : this.ucode);
            json.put(FormsContract.FormsTable.COLUMN_CLUSTER, this.cluster == null ? JSONObject.NULL : this.cluster);
            json.put(FormsContract.FormsTable.COLUMN_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);
            json.put(FormsContract.FormsTable.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
            json.put(FormsContract.FormsTable.COLUMN_DEVICETAGID, this.deviceTag == null ? JSONObject.NULL : this.deviceTag);
            json.put(FormsContract.FormsTable.COLUMN_APPVERSION, this.appver == null ? JSONObject.NULL : this.appver);
            json.put(FormsContract.FormsTable.COLUMN_GPS, this.gps == null ? JSONObject.NULL : this.gps);
            json.put(FormsContract.FormsTable.COLUMN_ENDINGDATETIME, this.endTime == null ? JSONObject.NULL : this.endTime);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS, this.iStatus == null ? JSONObject.NULL : this.iStatus);
            json.put(FormsContract.FormsTable.COLUMN_ISTATUS96x, this.iStatus96x == null ? JSONObject.NULL : this.iStatus96x);
            json.put(FormsContract.FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
            json.put(FormsContract.FormsTable.COLUMN_SYNCED_DATE, this.syncDate == null ? JSONObject.NULL : this.syncDate);
            json.put(FormsContract.FormsTable.COLUMN_G5FLAG, this.g5Flag == null ? JSONObject.NULL : this.g5Flag);

            json.put(FormsContract.FormsTable.COLUMN_S01HH, new JSONObject(s01HHtoString()));
            json.put(FormsContract.FormsTable.COLUMN_S05PD, new JSONObject(s05PDtoString()));
            json.put(FormsContract.FormsTable.COLUMN_S06BF, new JSONObject(s06BFtoString()));
            json.put(FormsContract.FormsTable.COLUMN_S07CV, new JSONObject(s07CVtoString()));
            json.put(FormsContract.FormsTable.COLUMN_S08SE, new JSONObject(s08SEtoString()));


            if (this.s01HH != null && !this.s01HH.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_S01HH, new JSONObject(this.s01HH));
            }

            if (this.s05PD != null && !this.s05PD.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_S05PD, new JSONObject(this.s05PD));
            }

            if (this.s06BF != null && !this.s06BF.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_S06BF, new JSONObject(this.s06BF));
            }

            if (this.s07CV != null && !this.s07CV.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_S07CV, new JSONObject(this.s07CV));
            }

            if (this.s08SE != null && !this.s08SE.equals("")) {
                json.put(FormsContract.FormsTable.COLUMN_S08SE, new JSONObject(this.s08SE));
            }

            return json;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void s01HHHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);
                this.hh01 = json.getString("hh01");
                this.hh0201 = json.getString("hh0201");
                this.hh0202 = json.getString("hh0202");
                this.hh03 = json.getString("hh03");
                this.hh04 = json.getString("hh04");
                this.hh05 = json.getString("hh05");
                this.hh06 = json.getString("hh06");
                this.hh07 = json.getString("hh07");
                this.hh08 = json.getString("hh08");
                this.hh09 = json.getString("hh09");
                this.hh10 = json.getString("hh10");
                this.hh11 = json.getString("hh11");
                this.hh12 = json.getString("hh12");
                this.hh13 = json.getString("hh13");
                this.hh14 = json.getString("hh14");
                this.hh15 = json.getString("hh15");
                this.hh16 = json.getString("hh16");
                this.hh17 = json.getString("hh17");
                this.hh1796x = json.getString("hh1796x");
                this.hh18 = json.getString("hh18");
                this.hh19 = json.getString("hh19");
                this.hh20 = json.getString("hh20");
                this.hh2096x = json.getString("hh2096x");
                this.hh21 = json.getString("hh21");
                this.hh22 = json.getString("hh22");
                this.hh23 = json.getString("hh23");
                this.hh24 = json.getString("hh24");
                this.hh25 = json.getString("hh25");
                this.hh26 = json.getString("hh26");
                this.hh2696x = json.getString("hh2696x");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s05PDHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.pd01 = json.getString("pd01");
                this.pd02 = json.getString("pd02");
                this.pd03 = json.getString("pd03");
                this.pd04 = json.getString("pd04");
                this.pd05 = json.getString("pd05");
                this.pd0596x = json.getString("pd0596x");
                this.pd06 = json.getString("pd06");
                this.pd06961x = json.getString("pd06961x");
                this.pd06962x = json.getString("pd06962x");
                this.pd07 = json.getString("pd07");
                this.pd0701x = json.getString("pd0701x");
                this.pd08 = json.getString("pd08");
                this.pd09 = json.getString("pd09");
                this.pd10 = json.getString("pd10");
                this.pd1101 = json.getString("pd1101");
                this.pd1102 = json.getString("pd1102");
                this.pd12 = json.getString("pd12");
                this.pd1296x = json.getString("pd1296x");
                this.pd13 = json.getString("pd13");
                this.pd13961x = json.getString("pd13961x");
                this.pd13962x = json.getString("pd13962x");
                this.pd14 = json.getString("pd14");
                this.pd1496x = json.getString("pd1496x");
                this.pd15 = json.getString("pd15");
                this.pd16 = json.getString("pd16");
                this.pd1601 = json.getString("pd1601");
                this.pd1602 = json.getString("pd1602");
                this.pd1603 = json.getString("pd1603");
                this.pd1604 = json.getString("pd1604");
                this.pd1605 = json.getString("pd1605");
                this.pd1606 = json.getString("pd1606");
                this.pd1607 = json.getString("pd1607");
                this.pd1696 = json.getString("pd1696");
                this.pd1696x = json.getString("pd1696x");
                this.pd17 = json.getString("pd17");
                this.pd1701x = json.getString("pd1701x");
                this.pd1702x = json.getString("pd1702x");
                this.pd1703x = json.getString("pd1703x");
                this.pd18 = json.getString("pd18");
                this.pd19 = json.getString("pd19");
                this.pd20 = json.getString("pd20");
                this.pd2001 = json.getString("pd2001");
                this.pd2002 = json.getString("pd2002");
                this.pd2003 = json.getString("pd2003");
                this.pd2004 = json.getString("pd2004");
                this.pd2005 = json.getString("pd2005");
                this.pd2006 = json.getString("pd2006");
                this.pd2007 = json.getString("pd2007");
                this.pd2096 = json.getString("pd2096");
                this.pd2096x = json.getString("pd2096x");
                this.pd21 = json.getString("pd21");
                this.pd2101x = json.getString("pd2101x");
                this.pd2102x = json.getString("pd2102x");
                this.pd2103x = json.getString("pd2103x");
                this.pd22 = json.getString("pd22");
                this.pddate = json.getString("pddate");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s06BFHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.bf01 = json.getString("bf01");
                this.bf02 = json.getString("bf02");
                this.bf03 = json.getString("bf03");
                this.bf3y = json.getString("bf3y");
                this.bf03m = json.getString("bf03m");
                this.bf3d = json.getString("bf3d");
                this.bf03a01 = json.getString("bf03a01");
                this.bf03a02 = json.getString("bf03a02");
                this.bf04 = json.getString("bf04");
                this.bf05 = json.getString("bf05");
                this.bf0502x = json.getString("bf0502x");
                this.bf0503x = json.getString("bf0503x");
                this.bf06 = json.getString("bf06");
                this.bf07 = json.getString("bf07");
                this.bf0796x = json.getString("bf0796x");
                this.bf08 = json.getString("bf08");
                this.bf09 = json.getString("bf09");
                this.bf0996x = json.getString("bf0996x");
                this.bf10 = json.getString("bf10");
                this.bf11 = json.getString("bf11");
                this.bf12 = json.getString("bf12");
                this.bf13 = json.getString("bf13");
                this.bfdate = json.getString("bfdate");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s07CVHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.cv01 = json.getString("cv01");
                this.cv02 = json.getString("cv02");
                this.cv03 = json.getString("cv03");
                this.cv04 = json.getString("cv04");
                this.cv0501 = json.getString("cv0501");
                this.cv0502 = json.getString("cv0502");
                this.cv0503 = json.getString("cv0503");
                this.cv0504 = json.getString("cv0504");
                this.cv0505 = json.getString("cv0505");
                this.cv0506 = json.getString("cv0506");
                this.cv0507 = json.getString("cv0507");
                this.cv0596 = json.getString("cv0596");
                this.cv0596x = json.getString("cv0596x");
                this.cv0601 = json.getString("cv0601");
                this.cv0602 = json.getString("cv0602");
                this.cv0603 = json.getString("cv0603");
                this.cv0604 = json.getString("cv0604");
                this.cv0605 = json.getString("cv0605");
                this.cv0606 = json.getString("cv0606");
                this.cv0607 = json.getString("cv0607");
                this.cv0608 = json.getString("cv0608");
                this.cv0609 = json.getString("cv0609");
                this.cv0610 = json.getString("cv0610");
                this.cv0611 = json.getString("cv0611");
                this.cv0696 = json.getString("cv0696");
                this.cv0696x = json.getString("cv0696x");
                this.cv07 = json.getString("cv07");
                this.cv0801 = json.getString("cv0801");
                this.cv0802 = json.getString("cv0802");
                this.cv0803 = json.getString("cv0803");
                this.cv0804 = json.getString("cv0804");
                this.cv0805 = json.getString("cv0805");
                this.cv0806 = json.getString("cv0806");
                this.cv0807 = json.getString("cv0807");
                this.cv0898 = json.getString("cv0898");
                this.cv0896 = json.getString("cv0896");
                this.cv0896x = json.getString("cv0896x");
                this.cv0901 = json.getString("cv0901");
                this.cv0902 = json.getString("cv0902");
                this.cv0903 = json.getString("cv0903");
                this.cv0904 = json.getString("cv0904");
                this.cv0905 = json.getString("cv0905");
                this.cv0906 = json.getString("cv0906");
                this.cv0907 = json.getString("cv0907");
                this.cv0998 = json.getString("cv0998");
                this.cv0996 = json.getString("cv0996");
                this.cv0996x = json.getString("cv0996x");
                this.cv1001 = json.getString("cv1001");
                this.cv1002 = json.getString("cv1002");
                this.cv1003 = json.getString("cv1003");
                this.cv1004 = json.getString("cv1004");
                this.cv1005 = json.getString("cv1005");
                this.cv1006 = json.getString("cv1006");
                this.cv1007 = json.getString("cv1007");
                this.cv1008 = json.getString("cv1008");
                this.cv1098 = json.getString("cv1098");
                this.cv1096 = json.getString("cv1096");
                this.cv1096x = json.getString("cv1096x");
                this.cv11 = json.getString("cv11");
                this.cv12 = json.getString("cv12");
                this.cv1296x = json.getString("cv1296x");
                this.cv13 = json.getString("cv13");
                this.cv14 = json.getString("cv14");
                this.cv15 = json.getString("cv15");
                this.cv16 = json.getString("cv16");
                this.cv1696x = json.getString("cv1696x");
                this.cv17 = json.getString("cv17");
                this.cv18 = json.getString("cv18");
                this.cv1896x = json.getString("cv1896x");
                this.cv19 = json.getString("cv19");
                this.cv1996x = json.getString("cv1996x");
                this.cvdate = json.getString("cvdate");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }


    public void s08SEHydrate(String string) {

        if (string != null) {

            try {
                JSONObject json = null;
                json = new JSONObject(string);

                this.se01 = json.getString("se01");
                this.se0196x = json.getString("se0196x");
                this.se02 = json.getString("se02");
                this.se0296x = json.getString("se0296x");
                this.se03 = json.getString("se03");
                this.se0396x = json.getString("se0396x");
                this.se04 = json.getString("se04");
                this.se0496x = json.getString("se0496x");
                this.se05 = json.getString("se05");
                this.se0596x = json.getString("se0596x");
                this.se06a = json.getString("se06a");
                this.se07a = json.getString("se07a");
                this.se08 = json.getString("se08");
                this.se0896x = json.getString("se0896x");
                this.se09 = json.getString("se09");
                this.se10 = json.getString("se10");
                this.se1099x = json.getString("se1099x");
                this.se11 = json.getString("se11");
                this.se1196x = json.getString("se1196x");
                this.se12 = json.getString("se12");
                this.se1296x = json.getString("se1296x");
                this.se13 = json.getString("se13");
                this.se14 = json.getString("se14");
                this.se15 = json.getString("se15");
                this.se16 = json.getString("se16");
                this.se17 = json.getString("se17");
                this.se1701 = json.getString("se1701");
                this.se1702 = json.getString("se1702");
                this.se1703 = json.getString("se1703");
                this.se1704 = json.getString("se1704");
                this.se1705 = json.getString("se1705");
                this.se1801 = json.getString("se1801");
                this.se1802 = json.getString("se1802");
                this.se1803 = json.getString("se1803");
                this.se1804 = json.getString("se1804");
                this.se1805 = json.getString("se1805");
                this.se1896 = json.getString("se1896");
                this.se189601x = json.getString("se189601x");
                this.se19 = json.getString("se19");
                this.se1996x = json.getString("se1996x");
                this.se20 = json.getString("se20");
                this.se2001 = json.getString("se2001");
                this.se2002 = json.getString("se2002");
                this.se2003 = json.getString("se2003");
                this.se2004 = json.getString("se2004");
                this.se2005 = json.getString("se2005");
                this.se2006 = json.getString("se2006");
                this.se2096 = json.getString("se2096");
                this.se2096x = json.getString("se2096x");
                this.se21 = json.getString("se21");
                this.se2101 = json.getString("se2101");
                this.se2102 = json.getString("se2102");
                this.se2103 = json.getString("se2103");
                this.se2104 = json.getString("se2104");
                this.se2105 = json.getString("se2105");
                this.se2196 = json.getString("se2196");
                this.se2196x = json.getString("se2196x");
                this.se2201 = json.getString("se2201");
                this.se2202 = json.getString("se2202");
                this.se2203 = json.getString("se2203");
                this.se2204 = json.getString("se2204");
                this.se2205 = json.getString("se2205");
                this.se2206 = json.getString("se2206");
                this.se2207 = json.getString("se2207");
                this.se2208 = json.getString("se2208");
                this.se2209 = json.getString("se2209");
                this.se2210 = json.getString("se2210");
                this.se2211 = json.getString("se2211");
                this.se2212 = json.getString("se2212");
                this.se2213 = json.getString("se2213");
                this.se2214 = json.getString("se2214");
                this.se2215 = json.getString("se2215");
                this.se2216 = json.getString("se2216");
                this.se2217 = json.getString("se2217");
                this.se2218 = json.getString("se2218");
                this.se23 = json.getString("se23");
                this.se24 = json.getString("se24");
                this.se25 = json.getString("se25");
                this.se26 = json.getString("se26");
                this.se27 = json.getString("se27");
                this.se2701 = json.getString("se2701");
                this.se2702 = json.getString("se2702");
                this.se2703 = json.getString("se2703");
                this.se2704 = json.getString("se2704");
                this.se28 = json.getString("se28");
                this.se2801 = json.getString("se2801");
                this.se2802 = json.getString("se2802");
                this.se2803 = json.getString("se2803");
                this.se29 = json.getString("se29");
                this.se30 = json.getString("se30");
                this.se3001 = json.getString("se3001");
                this.se3002 = json.getString("se3002");
                this.se3003 = json.getString("se3003");
                this.se3096 = json.getString("se3096");
                this.se3096x = json.getString("se3096x");
                this.se31 = json.getString("se31");
                this.se3196x = json.getString("se3196x");
                this.se32 = json.getString("se32");
                this.se3302 = json.getString("se3302");
                this.se3301 = json.getString("se3301");
                this.se3401 = json.getString("se3401");
                this.se3402 = json.getString("se3402");
                this.se35 = json.getString("se35");
                this.se36 = json.getString("se36");
                this.se37 = json.getString("se37");
                this.se3701 = json.getString("se3701");
                this.se3702 = json.getString("se3702");
                this.se3703 = json.getString("se3703");
                this.se3704 = json.getString("se3704");
                this.se3705 = json.getString("se3705");
                this.se3706 = json.getString("se3706");
                this.se3707 = json.getString("se3707");
                this.se3708 = json.getString("se3708");
                this.se3709 = json.getString("se3709");
                this.se3710 = json.getString("se3710");
                this.se3796 = json.getString("se3796");
                this.se3796x = json.getString("se3796x");
                this.se38 = json.getString("se38");
                this.se39 = json.getString("se39");
                this.se40 = json.getString("se40");
                this.sedate = json.getString("sedate");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}
