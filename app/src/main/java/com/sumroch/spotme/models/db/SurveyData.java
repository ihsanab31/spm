package com.sumroch.spotme.models.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by
 * Name     : Ihsan Abdurahman
 * Email    : ihsanab31@gmail.com
 * WA       : 0878253827096
 * on Sunday, 19-11-2017
 * ------------------------------
 * This class for
 */

@Data
@NoArgsConstructor
public class SurveyData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("survey")
    @Expose
    private String survey;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    private boolean selected;

    public static List<String> getSurveyStringList(List<SurveyData> surveyDataList) {
        List<String> surveyStringList = new ArrayList<>();
        for (SurveyData surveyData : surveyDataList) {
            surveyStringList.add(surveyData.getSurvey());
        }
        return surveyStringList;
    }

    public static List<Integer> getSelectedSurvey(List<SurveyData> surveyDataList) {
        List<Integer> selectedSurveyList = new ArrayList<>();
        for (SurveyData surveyData : surveyDataList) {
            if (surveyData.isSelected()) {
                selectedSurveyList.add(surveyData.getId());
            }
        }
        return selectedSurveyList;
    }
}