
package examen5;
import com.hp.hpl.jena.ontology.*; 
import com.hp.hpl.jena.rdf.model.ModelFactory; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.io.InputStream; 
import java.util.ArrayList;
import static java.util.Collections.list; 
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Principal {    
    final public static ArrayList<String> list = new ArrayList<>();
    final public static ArrayList<String> list2 = new ArrayList<>();
    final public static ArrayList<String> list3 = new ArrayList<>();
     
    public void devolverDatos(){
        OntClass cls;
        String rta;
        Individual ind = null;
        OntProperty ppp;
 
        OntModel personaOntology = ModelFactory.createOntologyModel(); 
        
        InputStream file = null; 
        try {
            file = new FileInputStream("C:/Users/USUARIO/Desktop/EXAMEN/Nuevoaeirrn00.owl");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        personaOntology.read(file,"",""); 
        
  
        for (Iterator<OntClass> i = personaOntology.listClasses();i.hasNext();){  //De Clases
            cls = i.next(); 
            rta=cls.getLocalName();
            if(rta!=null){
            list.add(cls.getLocalName());
            }
           // System.out.print(cls.getLocalName()+": ");
            for(Iterator it = cls.listInstances(true);it.hasNext();){       //De Individuos
                ind = (Individual)it.next();
                list2.add(ind.getLocalName());
             //   System.out.print(ind.getLocalName()+", ");
            }
            //System.out.println("");
            
        }
          //  System.out.println("RELACIONES: "); 
            for (Iterator ii = personaOntology.listRestrictions();ii.hasNext();){
                Restriction pp = (Restriction) ii.next(); 
                list3.add(pp.getOnProperty().getDomain().getLocalName()+"  "+pp.getOnProperty().getLocalName()+"  "+pp.getOnProperty().getRange().getLocalName());
                //System.out.println(pp.getOnProperty().getLocalName()+"la inversa es"+pp.getOnProperty().getEquivalentProperty().getLocalName());
               
            }
           
    }
}

