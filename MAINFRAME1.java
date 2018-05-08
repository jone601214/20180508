import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MAINFRAME1 extends JFrame {
    private JButton jbtnRun=new JButton("Run");
    private JButton jbtnReset=new JButton("Reset");
    private JButton jbtnExit=new JButton("Exit");
    private JButton jbtns[][]=new JButton[3][3];
    private Container cp;
    private JPanel jpnC=new JPanel(new GridLayout(3,3,3,3));
    private JPanel jpncR=new JPanel(new GridLayout(3,3,3,3));
    private boolean flag=true;
    public MAINFRAME1(){
        init();
    }
    private void init(){
        this.setBounds(100,100,600,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(jpnC,BorderLayout.CENTER);
        cp.add(jpncR,BorderLayout.EAST);
        jpncR.add(jbtnRun);
        jpncR.add(jbtnReset);
        jpncR.add(jbtnExit);

        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                jbtns[i][j]=new JButton();
                jbtns[i][j].setBackground(new Color(84, 244, 255));
                jbtns[i][j].setFont(new Font(null,Font.BOLD,72));
                jbtns[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent  e) {
                        JButton tmpBtn=(JButton) e.getSource();
                        if (tmpBtn.getText().equals("")){
                            if (flag){
                                tmpBtn.setText("O");
                            }else {
                                tmpBtn.setText("X");
                            }
                            flag=!flag;
                        }
                        checkStat();
                    }
                });
                jpnC.add(jbtns[i][j]);
            }
        }
        jbtnRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });
        jbtnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<3;i++){
                    for (int j=0;j<3;j++){
                        jbtns[i][j].setText("");
                        jbtns[i][j].setEnabled(true);
                    }
                }
            }
        });
        jbtnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
    private void checkStat(){
        if (jbtns[0][0].getText().equals(jbtns[0][1].getText())&&jbtns[0][0].getText().equals(jbtns[0][2].getText())&&!jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this,jbtns[0][0].getText()+"WIN~~");
        }else if (jbtns[1][0].getText().equals(jbtns[1][1].getText())&&jbtns[1][0].getText().equals(jbtns[1][2].getText())&&!jbtns[1][0].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this,jbtns[0][0].getText()+"WIN~~");
        }else if (jbtns[2][0].getText().equals(jbtns[2][1].getText())&&jbtns[2][0].getText().equals(jbtns[2][2].getText())&&!jbtns[2][0].getText().equals("")) {
            JOptionPane.showMessageDialog(MAINFRAME1.this, jbtns[0][0].getText() + "WIN~~");
        }else if (jbtns[0][0].getText().equals(jbtns[1][0].getText())&&jbtns[0][0].getText().equals(jbtns[2][0].getText())&&!jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this, jbtns[0][0].getText() + "WIN~~");
        }else if (jbtns[0][1].getText().equals(jbtns[1][1].getText())&&jbtns[0][1].getText().equals(jbtns[2][1].getText())&&!jbtns[0][1].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this, jbtns[0][0].getText() + "WIN~~");
        }else if (jbtns[0][2].getText().equals(jbtns[1][2].getText())&&jbtns[0][2].getText().equals(jbtns[2][2].getText())&&!jbtns[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this, jbtns[0][0].getText() + "WIN~~");
        }else if (jbtns[0][0].getText().equals(jbtns[1][1].getText())&&jbtns[0][0].getText().equals(jbtns[2][2].getText())&&!jbtns[0][0].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this, jbtns[0][0].getText() + "WIN~~");
        }else if (jbtns[0][2].getText().equals(jbtns[1][1].getText())&&jbtns[0][2].getText().equals(jbtns[2][0].getText())&&!jbtns[0][2].getText().equals("")){
            JOptionPane.showMessageDialog(MAINFRAME1.this, jbtns[0][0].getText() + "WIN~~");
        }
    }
}
