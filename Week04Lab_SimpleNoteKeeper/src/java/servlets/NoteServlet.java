/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.*;
import models.Note;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rizz4
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (request.getParameter("edit").equals("")) {
                String path = getServletContext().getRealPath("/WEB-INF/note.txt");

            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String title = br.readLine();
            String content = br.readLine();
            Note note = new Note(title, content);
            br.close();
            request.setAttribute("note", note);
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        } catch (Exception e) {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");

            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            
            String title = br.readLine();
            String content = br.readLine();
            Note note = new Note(title, content);
            br.close();
            request.setAttribute("note", note);
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        pw.write(title + "\n");
        pw.write(content + "\n");
        Note note = new Note(title, content);
        request.setAttribute("note", note);
        pw.close();
        
       request.getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

}
