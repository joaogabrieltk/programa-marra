/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocliente;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jorge
 */
public class UsuarioDAO {

    private static PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private final Connection connection;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,telefone,email,logradouro,numero,bairro,cidade,estado) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement insert = connection.prepareStatement(sql)) {
                insert.setString(1, usuario.getNome());
                insert.setString(2, usuario.getCpf());
                insert.setString(3, usuario.getTelefone());
                insert.setString(4, usuario.getEmail());
                insert.setString(5, usuario.getLogradouro());
                insert.setString(6, usuario.getNumero());
                insert.setString(7, usuario.getBairro());
                insert.setString(8, usuario.getCidade());
                insert.setString(9, usuario.getEstado());
                insert.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public void buscacadastro(Usuario usuario) {
        //String sql = "SELECT INTO usuario(nome,cpf,telefone,email,logradouro,numero,bairro,cidade,estado) VALUES(?,?,?,?,?,?,?,?,?)";
        String sql = "SELECT INTO usuario(nome=?,cpf=?,telefone=?,email=?,logradouro=?,numero=?,bairro=?,cidade=?,estado=?)";
        try {
            try (PreparedStatement select = connection.prepareStatement(sql)) {
                select.setString(1, usuario.getNome());
                select.setString(2, usuario.getCpf());
                select.setString(3, usuario.getTelefone());
                select.setString(4, usuario.getEmail());
                select.setString(5, usuario.getLogradouro());
                select.setString(6, usuario.getNumero());
                select.setString(7, usuario.getBairro());
                select.setString(8, usuario.getCidade());
                select.setString(9, usuario.getEstado());
                select.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
    
    public void deleta(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,telefone,email,logradouro,numero,bairro,cidade,estado) VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            try (PreparedStatement insert = connection.prepareStatement(sql)) {
                insert.setString(1, usuario.getNome());
                insert.setString(2, usuario.getCpf());
                insert.setString(3, usuario.getTelefone());
                insert.setString(4, usuario.getEmail());
                insert.setString(5, usuario.getLogradouro());
                insert.setString(6, usuario.getNumero());
                insert.setString(7, usuario.getBairro());
                insert.setString(8, usuario.getCidade());
                insert.setString(9, usuario.getEstado());
                insert.execute();
            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }



    public List<Usuario> getUsuarios(String nome) {
        
        //SELECT * FROM usuario WHERE nome like '%a%' ORDER BY nome ASC;//

        String sql = "SELECT * FROM usuario WHERE nome = '" + nome + "'";
        System.out.println(sql);

        List<Usuario> usuarios = new ArrayList<>();

        PreparedStatement pstm = null;
        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {

            pstm = connection.prepareStatement(sql);

            rset = pstm.executeQuery();

            //Enquanto existir dados no banco de dados, faça
            while (rset.next()) {

                Usuario user = new Usuario();

                //Recupera o id do banco e atribui ele ao objeto
                user.setCodigo(rset.getString("codigo"));

                //Recupera o id do banco e atribui ele ao objeto
                user.setBairro(rset.getString("bairro"));

                //Recupera o nome do banco e atribui ele ao objeto
                user.setCidade(rset.getString("cidade"));

                //Recupera a idade do banco e atribui ele ao objeto
                user.setCpf(rset.getString("cpf"));

                //Recupera a data do banco e atribui ela ao objeto
                user.setEmail(rset.getString("email"));

                user.setEstado(rset.getString("estado"));

                user.setLogradouro(rset.getString("logradouro"));

                user.setNome(rset.getString("nome"));

                user.setNumero(rset.getString("numero"));

                user.setTelefone(rset.getString("telefone"));

                //Adiciono o contato recuperado, a lista de contatos
                usuarios.add(user);
            }
        } catch (Exception e) {
        } finally {

            try {

                if (rset != null) {

                    rset.close();
                }

                if (pstm != null) {

                    pstm.close();
                }

                if (connection != null) {
                    connection.close();
                }

            } catch (Exception e) {
            }
        }

        return usuarios;
    }
    
}
