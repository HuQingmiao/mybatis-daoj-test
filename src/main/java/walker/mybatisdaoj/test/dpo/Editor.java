package walker.mybatisdaoj.test.dpo; 

import walker.mybatisdaoj.test.common.BasicPo; 

public class Editor extends BasicPo {
    private static final long serialVersionUID = 1L;

    public static final String $TABLE_NAME = "EDITOR";

    public static final String $EDITOR_ID = "editorId";
    public static final String $NAME = "name";
    public static final String $SEX = "sex";

    private Long editorId;
    private String name;
    private String sex;

    public Editor () {
    }

    public Long getEditorId() {
        return editorId;
   }

    public void setEditorId(Long editorId) {
        this.editorId = editorId;
   }

    public String getName() {
        return name;
   }

    public void setName(String name) {
        this.name = name;
   }

    public String getSex() {
        return sex;
   }

    public void setSex(String sex) {
        this.sex = sex;
   }

}

