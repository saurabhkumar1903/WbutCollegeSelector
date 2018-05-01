package com.example.hp.wbutcollegeselector;

/**
 * Created by hp on 27-07-2017.
 */

public class College
{
    private String CollegeId;
    private String Name;
    private String InstituteType;
    private String StreamsTaught;
    CivilEngineering ci;
    ComputerScienceEngineering cse;
    ElectricalEngineering ee;
    ElectronicsAndCommunicationEngineering ece;
    MechanicalEngineering me;


    private String Facilities;
    CollegeRank collegeRank;


    public College(String name, String instituteType, String streamsTaught, CivilEngineering ci, ComputerScienceEngineering cse, ElectricalEngineering ee, ElectronicsAndCommunicationEngineering ece, MechanicalEngineering me, String facilities, CollegeRank collegeRank) {
        Name = name;
        InstituteType = instituteType;
        StreamsTaught = streamsTaught;
        this.ci = ci;
        this.cse = cse;
        this.ee = ee;
        this.ece = ece;
        this.me = me;
        Facilities = facilities;
        this.collegeRank = collegeRank;
    }

    public String getCollegeId() {
        return CollegeId;
    }

    public void setCollegeId(String collegeId) {
        CollegeId = collegeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInstituteType() {
        return InstituteType;
    }

    public void setInstituteType(String instituteType) {
        InstituteType = instituteType;
    }

        public String getStreamsTaught() {
        return StreamsTaught;
    }

    public void setStreamsTaught(String streamsTaught) {
        StreamsTaught = streamsTaught;
    }

    public String getFacilities() {
        return Facilities;
    }

    public void setFacilities(String facilities) {
        Facilities = facilities;
    }

    public CollegeRank getRank() {
        return collegeRank;
    }

    public void setRank(CollegeRank Rank) {
        this.collegeRank = Rank;
    }
}
