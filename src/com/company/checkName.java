package com.company;

public class checkName{
String parseKey;
    public String checkName(String name){
        switch (name){ //this will most likely create a bug where pokeDesc is accurate, but can't be parse for the name variable
            case "nidoran-f":
                name = "Nidoran♀";
                break;
            case "farfetchd":
                name = "Farfetch%27d";
                parseKey = "lulw";

                break;
            case "mr-mime":
                name = "Mr._Mime";
                break;
            case "mime-jr":
                name = "Mime_Jr.";
                break;
            case "meloetta-aria":
                name = "Meloetta";
                break;
            case "type-null":
                name = "Type:_Null";
                break;
            case "tapu-koko":
                name = "Tapu_Koko";
                break;
            case "tapu-lele":
                name = "Tapu_Lele";
                break;
            case "tapu-bulu":
                name = "Tapu_Bulu";
                break;
            case "tapu-fini":
                name = "Tapu_Fini";
                break;
        }



        return name;
    }
        public String getParseKey(){











        return parseKey;
        }
}
