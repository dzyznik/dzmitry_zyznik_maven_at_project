package parser;

public class Search {
    public String user;
    boolean strict;

    public String id;

    public String realName;

    public Search(String user, boolean strict){
        this.user = user;
        this.strict = strict;
    }

//    public Search(String id){
//        this.id = id;
//    }

    public Search(String realName){
        this.realName = realName;
    }
}
