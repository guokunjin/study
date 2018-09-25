package cn.gkj.demo.entry;

public class Questionnaire {
    private Integer id;

    private String questionnaireContent;

    private String questionnaireName;

    private Integer status;

    private String uId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestionnaireContent() {
        return questionnaireContent;
    }

    public void setQuestionnaireContent(String questionnaireContent) {
        this.questionnaireContent = questionnaireContent == null ? null : questionnaireContent.trim();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Questionnaire{");
        sb.append("id=").append(id);
        sb.append(", questionnaireContent='").append(questionnaireContent).append('\'');
        sb.append(", questionnaireName='").append(questionnaireName).append('\'');
        sb.append(", status=").append(status);
        sb.append(", uId='").append(uId).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName == null ? null : questionnaireName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }
}