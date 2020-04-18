package com.company;

public class checkName{
String parseKey = null;
    public String checkName(String name){
        switch (name){ //this will most likely create a bug where pokeDesc is accurate, but can't be parse for the name variable
            case "nidoran-f":
                name = "Nidoran♀";
                parseKey = "Nidoran♀";
                break;
            case "farfetchd":
                name = "Farfetch%27d";
                parseKey = "Farfetch'd";
                break;
            case "mr-mime":
                name = "Mr._Mime";
                parseKey = "Mr. Mime";
                break;
            case "mime-jr":
                name = "Mime_Jr.";
                parseKey = "Mime Jr.";
                break;
            case "meloetta-aria":
                name = "Meloetta";
                parseKey = "Meloetta";
                break;
            case "type-null":
                name = "Type:_Null";
                parseKey = "Type: Null";
                break;
            case "tapu-koko":
                name = "Tapu_Koko";
                parseKey = "Tapu Koko";
                break;
            case "tapu-lele":
                name = "Tapu_Lele";
                parseKey = "Tapu Lele";
                break;
            case "tapu-bulu":
                name = "Tapu_Bulu";
                parseKey = "Tapu Bulu";
                break;
            case "tapu-fini":
                name = "Tapu_Fini";
                parseKey = "Tapu Fini";
                break;
        }



        return name;
    }
        public String getParseKey(){
        return parseKey;
        }
}
