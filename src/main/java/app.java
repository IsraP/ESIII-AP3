import controle.AppDAO;
import modelo.Arma;
import modelo.Crime;
import modelo.Criminoso;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class app {
    public static void main(String[] args) {
        AppDAO<Arma> appDAO = new AppDAO<>();

//        List<Arma> armas = new ArrayList<>();
//
//        for(int i = 0; i < 10; i++)
//            armas.add(new Arma("Arma" + i, "De Fogo", null));
//
//        armas.forEach(appDAO::insert);

        System.out.println(appDAO.getAll(Arma.class));
    }

}
