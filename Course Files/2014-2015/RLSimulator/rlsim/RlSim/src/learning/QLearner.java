/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learning;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author alessandrobisiani
 */
public class QLearner {
    
    private double epsilon;
    private double alpha;
    //These are default table models because DefaultTableModel includes more methods for operating on the model and extracting table data
    private JTable qMatrix;
    private JTable rMatrix;
    private TableModel qModel;
    private TableModel rModel;
    
    public QLearner(JTable q, JTable r){
        qMatrix = q;
        rMatrix = r;
        qModel = new DefaultTableModel(new Object[][] {{"state1",0,0,0,0,0,0,0,0,0}, 
                                                            {"state2",0,0,0,0,0,0,0,0,0}, 
                                                            {"state3",0,0,0,0,0,0,0,0,0},
                                                            {"state4",0,0,0,0,0,0,0,0,0},
                                                            {"state5",0,0,0,0,0,0,0,0,0},
                                                            {"state6",0,0,0,0,0,0,0,0,0},
                                                            {"state7",0,0,0,0,0,0,0,0,0},
                                                            {"state8",0,0,0,0,0,0,0,0,0},
                                                            {"state9",0,0,0,0,0,0,0,0,0},
                                                            {"state10",0,0,0,0,0,0,0,0,0}}, 
                                             new String[] {"","state1","state2","state3","state4",
                                                 "state5","state6","state7","state8","state9"});
        rModel = new DefaultTableModel(new Object[][] {{"state1",1,2,3,4,5,6,7,8,9}, 
                                                            {"state2",10,11,12,0,0,0,0,0,0}, 
                                                            {"state3",0,0,0,0,0,0,0,0,0},
                                                            {"state4",0,0,0,0,0,0,0,0,0},
                                                            {"state5",0,0,0,0,0,0,0,0,0},
                                                            {"state6",0,0,0,0,0,0,0,0,0},
                                                            {"state7",0,0,0,0,0,0,0,0,0},
                                                            {"state8",0,0,0,0,0,0,0,0,0},
                                                            {"state9",0,0,0,0,0,0,0,0,0},
                                                            {"state10",0,0,0,0,0,0,0,0,0}}, 
                                             new String[] {"","state1","state2","state3","state4",
                                                 "state5","state6","state7","state8","state9"});
        q.setModel(qModel);
        r.setModel(rModel);
        
    }
    
    public void episode(){
        
    }

    public void eGreedy(){
        
    }
    
    public void setEpsilon(double e){
        epsilon = e;
    }
    public void setAlpha(double a){
        alpha = a;
    }
    //Sets the pointers to QLearner's model fields to the parameters taken. Point of doing it manually is to maintain them as DefaultTableModels.
    public void setModels(DefaultTableModel q, DefaultTableModel r){
        qModel = q;
        rModel = r;
    }
}
