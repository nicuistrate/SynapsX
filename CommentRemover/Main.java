package CommentRemover;

public class Main {
    public static void main(String[] args) {

        String result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", "#,!");
        System.out.println(result);

    }

    public static String solution(String text, String semne) {

        String[] propozitii = text.split("\n");// impartim fiecare rand in propozitii
        String[] semneSplit = semne.split(",");// delimitam semnele pe care le avem
        String nouText = "";
        String textModificat="";
        String nouaPropozitie="";
        boolean elementGasit=true;
        int[] numarImpartire = new int[semneSplit.length];

        for (int i = 0; i < propozitii.length; i++) {
            for (int j = 0; j < semneSplit.length; j++) {
                String[] cuvinte = propozitii[i].split(semneSplit[j]); // verificam fiecare semn daca se afla in propozitie
                numarImpartire[j] = cuvinte.length;// daca un semn se afla inregistram de cate ori functia split imparte propozitia
                                                    // un numar mai mare de impartiri indica un sectionare mai buna a cuvintelor
            }
            int pozitie=0;
            int aux=0;
            int numarCaractere=0;
            for(int k=0;k<numarImpartire.length;k++)
            {

                if(numarImpartire[k]>=aux){  //cautam propozitia care a fost impartita de cele mai multe ori si retinem pozitia acesteia
                    if(aux==numarImpartire[k])
                    {
                        aux=numarImpartire[k];
                    }


                    pozitie=k;
                }
            }
            String[] cuvinte = propozitii[i].split(semneSplit[pozitie]);
            textModificat=cuvinte[0].replaceAll("["+semne+"]","");
            nouText = nouText+textModificat+ "\n"; //retinem propozitiile pe rand intr-un text nou

        }


        return nouText; //returnam acel text
    }
}