package sn.isi.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DB {
        //Pour la connexion
        private Connection cxion;
        //Pour les resultats de type SELECT
        private ResultSet rset;
        //Pour les requetes preparees
        private PreparedStatement pstm;// preparer la requete sql avant l'exe
        //Pour les requetes de type MAJ
        private int ok;

        private void getConnection() throws Exception{
            String url = "jdbc:mysql://localhost:3306/mailing";
            String mysqluser = "root";
            String mysqlpassword = "";

            Class.forName("com.mysql.jdbc.Driver");
            cxion = DriverManager.getConnection(url, mysqluser, mysqlpassword);    }

        //initialisation des requetes
        public void init(String sql) throws Exception{
            getConnection();
            pstm = cxion.prepareStatement(sql);
        }
        //execution
        public ResultSet executeSelect() throws Exception{
            rset = null;//facultatif
            rset = pstm.executeQuery();
            return rset;
        }
        //execution des requetes de types Update
        public int executeMaj() throws Exception{
                ok = pstm.executeUpdate();
            return ok;
        }
        //Fermeture de la connexion a la base
        public void close() throws Exception{
            if (cxion != null){
                cxion.close();
            }
        }

        public PreparedStatement getPstm() {
            return pstm;
        }

}
