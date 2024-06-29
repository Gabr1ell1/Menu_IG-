package lista12;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Lista12 extends JFrame
{
    JLabel img;
    JMenuBar barra;//DECLARANDO A BARRA DO MENU
    JMenu operacoes, sobre, sair;//ADICIONADO OS ITENS DO MENU
    JMenuItem  soma, divi, multi, sub, desenvolvedor, fechar;//COLOCANDO ITENS DO JMENU
    somajanela somajanela;
    MultiplicacaoJanela multijanela; // Declarando a janela para multiplicação
    SubtracaoJanela subjanela; // Declarando a janela para subtração
    DivisaoJanela divjanela; // Declarando a janela para divisão
    SobreJanela sobrejanela; // Declarando a janela para sobre
    
    JToolBar barraF; //BARRA DE FERRAMENTAS
    JButton Soma,Divi,Multi,Sub,sair1;//OPÇÕES DA BARRA DE FERRAMENTAS
    ImageIcon images[];
    JPopupMenu opcoes;//MENU POPUP
    JMenuItem Sobre, Sair;//OPÇÕES DO MENU POPUP
    
    
    public Lista12(){
        super("Menu");
            Container tela = getContentPane();
        tela.setLayout(null);
    
       //ADICIONANDO O ICONE
      ImageIcon icon = new ImageIcon("operacoes-matematicas.png");
      img = new JLabel(icon);
      img.setBounds(0,0,700,700);
      tela.add(img);
      tela.setBackground(Color.blue);
     
    
    barra = new JMenuBar();//CRIAndo DA BARRA DE MENU
    setJMenuBar(barra);//ANEXANDO A BARRA MENU Á JANELA 
    
    operacoes = new JMenu("Operações");//CRIANDO O MENU 
    barra.add(operacoes);
   
    //ADICIONANDO UM SUBMENU
    soma = new JMenuItem("Soma");
    divi = new JMenuItem("Divisão");
    multi = new JMenuItem("Multiplicação");
    sub = new JMenuItem("Subtração");
    
    operacoes.add(soma);
    operacoes.add(divi);
    operacoes.add(multi);
    operacoes.add(sub);
    
    sobre = new JMenu("Sobre");
    desenvolvedor = new JMenuItem("Desenvolvedor");
    sobre.add(desenvolvedor);
    
    sair = new JMenu("Sair");
    fechar = new JMenuItem("Fechar");
    sair.add(fechar);
    
    // opção "sair" perguntará se quer sair ou não.
    fechar.addActionListener(
    new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[] botoes = {"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
        if (opcao==JOptionPane.YES_OPTION)
        System.exit(0); 
        }
     }
   );


    sobre.setMnemonic(KeyEvent.VK_F);//ATALHO
    sair.setMnemonic(KeyEvent.VK_S);//ATALHO
    
    barra.add(operacoes);//ADICIONANDO A TELA
    barra.add(sobre);//ADICIONANDO A TELA
    barra.add(sair);//ADICIONANDO A TELA
    
    
  
    //CHAMANDO AS FORMULÁRIOS MODAIS DE CADA OPERAÇÃO
    //--SOMA
    soma.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    somajanela = new somajanela(null,"Somando os Números!! ",true);
    somajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    somajanela.setVisible(true);
        }
    }
);
    //--MULTIPLICAÇÃO
    multi.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    multijanela = new MultiplicacaoJanela(null,"Multiplicando os Números!!",true);
    multijanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    multijanela.setVisible(true);
        }
    }
);
    //--SUBTRAÇÃO
    sub.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    subjanela = new SubtracaoJanela(null,"Subtraindo os Números!!",true);
    subjanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    subjanela.setVisible(true);
        }
    }
);
    //--DIVISÃO
    divi.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    divjanela = new DivisaoJanela(null,"Dividindo os Números",true);
    divjanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    divjanela.setVisible(true);
        }
    }
);
    //--JANELA 'SOBRE'
    desenvolvedor.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    sobrejanela = new SobreJanela(null,"Sobre",true);
    sobrejanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    sobrejanela.setVisible(true);
        }
    }
);
    //BARRA DE FERRAMENTAS
     //ADICIONANDO A BARRA DE FERRAMENTAS SEUS BOTÕES E ICONES
      String icones[]={"IconeAdicao.png","iconeDivisao.png", "iconeMultiplicacao.png","iconeSub.png", "sair.png"};
      images = new ImageIcon[5];
      
      //CARREGANDO OS ICONES
      for(int i = 0;i < 5;i++){
        images[i] = new ImageIcon(icones[i]);
      
      }
      //CRIANDO OS BOTÕES COM ICONES
        Soma = new JButton(images[0]);       
        Divi = new JButton(images[1]);
        Multi = new JButton(images[2]);
        Sub = new JButton(images[3]);
        sair1 = new JButton(images[4]);
       
        //ADICIONANDO DICAS AOS BOTÕES
        Soma.setToolTipText("Somar");
        Divi.setToolTipText("Dividir");
        Multi.setToolTipText("Multiplicar");
        Sub.setToolTipText("Subtrair");
        sair1.setToolTipText("Sair");
        
        //CRIANDO A BARRA DE FERRAMENTAS
        barraF = new JToolBar("Barra de Ferramentas");
        
        barraF.setBounds(1,1,260,50);
        
        //PERSONALIZAÇÃO DAS DICAS
        UIManager.put("ToolTip.background",SystemColor.info);
        UIManager.put("ToolTip.foreground",Color.black);
        
        //CHAMANDO AS JANELAS DE OPERAÇÕES PELA BARRA DE FERRAMENTA
        Soma.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    somajanela = new somajanela(null,"Somando os Números!! ",true);
    somajanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    somajanela.setVisible(true);
        }
    }
);
        Multi.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    multijanela = new MultiplicacaoJanela(null,"Multiplicando os Números!!",true);
    multijanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    multijanela.setVisible(true);
        }
    }
);
        Sub.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    subjanela = new SubtracaoJanela(null,"Subtraindo os Números!!",true);
    subjanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    subjanela.setVisible(true);
        }
    }
);
         Divi.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    divjanela = new DivisaoJanela(null,"Dividindo os Números",true);
    divjanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    divjanela.setVisible(true);
        }
    }
);
          sair1.addActionListener(
    new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[] botoes = {"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
        if (opcao==JOptionPane.YES_OPTION)
        System.exit(0); 
        }
     }
   );
         
        barraF.setRollover(true);//A BARRA DE FERRAMENTA É ROLÁVEL
        //ADICIONANDO OS INTEMS A BARRA DE FERRAMENTA
        barraF.add(Soma);
        barraF.add(Divi);
        barraF.add(Multi);
        barraF.add(Sub);
        barraF.add(sair1);
        barraF.addSeparator();//SEPARADOR
       
        tela.add(barraF);
    
        //ADICIONANDO UM LISTENER AO MOUSE PARA O MENU POPUP
        tela.addMouseListener(new MouseAdapter(){
        public void mouseReleased(MouseEvent e){
        if(e.isPopupTrigger())
        opcoes.show(e.getComponent(),e.getX(),e.getY()); 
                }
            }
        );

        //CRIANDO O MENU POPUP E ADICIONANDO OS SEUS ITENS
        opcoes = new JPopupMenu();
        Sobre = new JMenuItem("Sobre");
        Sair = new JMenuItem("Sair");
        
   //JANELA MODAL 'SOBRE'     
    Sobre.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
    sobrejanela = new SobreJanela(null,"Sobre",true);
    sobrejanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    sobrejanela.setVisible(true);
        }
    }
);
    Sair.addActionListener(
    new ActionListener(){
        public void actionPerformed(ActionEvent e){
        int opcao;
        Object[] botoes = {"Sim","Não"};
        opcao = JOptionPane.showOptionDialog(null,"Deseja mesmo sair?","Fechar",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,botoes,botoes[0]);
        if (opcao==JOptionPane.YES_OPTION)
        System.exit(0); 
        }
     }
   );
    
        opcoes.add(Sobre);
        opcoes.add(Sair);

    
    //DEFINIÇÕES DA JANELA
    setSize(800,800);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
}
    
    //---------------
    public static void main(String[] args) {
       Lista12 app =  new Lista12();
       app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //---------------
    
//---------------------------------------------------------------
    private class somajanela extends JDialog{
    JButton limpar, voltar, somar;//DECLARANDO JBUTTON'S
    JLabel rotulo1, rotulo2, exibir;//DECLARANDO JLABEL'S
    JTextField texto1, texto2;//DECLARANDO JTEXTFIELD'S
 
    
    public somajanela(Frame owner, String title,boolean modal)
    {
    super(owner,title,modal);
    Container tela1 = getContentPane();
    tela1.setLayout(null);
    
    //ADICIONANDO O ICONE
      ImageIcon icone = new ImageIcon("adicionar.png");
      setIconImage(icone.getImage());
     
      
      
    //ATRIBUINDO OS VALORES
    rotulo1 = new JLabel("1º Número: ");
    rotulo2 = new JLabel("2º Número: ");
    texto1 = new JTextField(5);
    texto2 = new JTextField(5);
    exibir = new JLabel("");//LABEL QUE APRESENTARÁ O RESULTADO
    somar = new JButton("Somar");//BOTÃO SOMAR
    
    //DEFININDO POSIÇÕES
    rotulo1.setBounds(50,20,100,20);
    rotulo2.setBounds(50,60,100,20);
    texto1.setBounds(120,20,200,20);
    texto2.setBounds(120,60,200,20);
    exibir.setBounds(50,140,200,20);
    somar.setBounds(150,100,80,20);
    
    //SOMANDO
    somar.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
    int numero1, numero2, soma;
    soma = 0;
    numero1 = Integer.parseInt(texto1.getText());
    numero2 = Integer.parseInt(texto2.getText());
    soma = numero1 + numero2;
    
    exibir.setVisible(true);
    exibir.setText("A soma é: "+soma);
        }
    }
);
    //ADICIONANDO A TELA
    exibir.setVisible(false);
    tela1.add(rotulo1);
    tela1.add(rotulo2);
    tela1.add(texto1);
    tela1.add(texto2);
    tela1.add(exibir);
    tela1.add(somar);

    //BOTÃO VOLTAR
    voltar = new JButton("Voltar");
    voltar.setBounds(50,200,100,20);
    tela1.add(voltar);
    
    //VOLATNDO
    voltar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
       dispose();
        }
    }
);
    
    //BOTÃO LIMPAR
    limpar = new JButton("Limpar");
    limpar.setBounds(150,200,100,20);
    tela1.add(limpar);

    //LIMPANDO
    limpar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        texto1.setText(null);
        texto2.setText(null);
        exibir.setText(null);
                }
            }
        );
    
    setSize(400,300);
    setLocationRelativeTo(null);
    }    
}
//-----------------------------------------------------------
private class MultiplicacaoJanela extends JDialog{
    JButton voltar, limpar,Multiplicar;
    JLabel img, rotulo1, rotulo2, exibir;
    JTextField texto1, texto2;
    
public MultiplicacaoJanela(Frame owner, String title,boolean modal)
    {
    super(owner,title,modal);
    Container tela1 = getContentPane();
    tela1.setLayout(null);
    
    //ADICIONANDO O ICONE
      ImageIcon icone = new ImageIcon("multiplicacao.png");
       setIconImage(icone.getImage());
       
    rotulo1 = new JLabel("1º Número: ");
    rotulo2 = new JLabel("2º Número: ");
    texto1 = new JTextField(5);
    texto2 = new JTextField(5);
    exibir = new JLabel("");
    Multiplicar = new JButton("Multiplicar");
    
    
    rotulo1.setBounds(50,20,100,20);
    rotulo2.setBounds(50,60,100,20);
    texto1.setBounds(120,20,200,20);
    texto2.setBounds(120,60,200,20);
    exibir.setBounds(50,140,200,20);
    Multiplicar.setBounds(150,100,100,20);
    
    
    Multiplicar.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
    int numero1, numero2, Multiplicar;
    Multiplicar = 0;
    
    numero1 = Integer.parseInt(texto1.getText());
    numero2 = Integer.parseInt(texto2.getText());
    
    Multiplicar = numero1 * numero2;
    
    exibir.setVisible(true);
    exibir.setText("A Multiplicação é: "+Multiplicar);
        }
    }
);
    exibir.setVisible(false);
    tela1.add(rotulo1);
    tela1.add(rotulo2);
    tela1.add(texto1);
    tela1.add(texto2);
    tela1.add(exibir);
    tela1.add(Multiplicar);

    voltar = new JButton("Voltar");
    voltar.setBounds(50,200,100,20);
    
    tela1.add(voltar);
    
    
    voltar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
       dispose();
        }
    }
);
    
    
    limpar = new JButton("Limpar");
    limpar.setBounds(150,200,100,20);
    
    tela1.add(limpar);
    
    
    limpar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        texto1.setText(null);
        texto2.setText(null);
        exibir.setText(null);
        }
    }
);
    setSize(400,300);
    setLocationRelativeTo(null);
    }
}
 //---------------------------------------------------------------------------
    private class SubtracaoJanela extends JDialog{
    JButton voltar, limpar, subtrair;//DECLARANDO JBUTTON'S
    JLabel img, rotulo1, rotulo2, exibir;//DECLARANDO JLABEL'S
    JTextField texto1, texto2;//DECLARANDO JTEXTFIELD'S
 
    
    public SubtracaoJanela(Frame owner, String title,boolean modal)
    {
    super(owner,title,modal);
    Container tela1 = getContentPane();
    tela1.setLayout(null);
    
    //ADICIONANDO O ICONE
      ImageIcon icone = new ImageIcon("subtrair.png");
       setIconImage(icone.getImage());
    
    //ATRIBUINDO OS VALORES
    rotulo1 = new JLabel("1º Número: ");
    rotulo2 = new JLabel("2º Número: ");
    texto1 = new JTextField(5);
    texto2 = new JTextField(5);
    exibir = new JLabel("");
    subtrair = new JButton("Subtrair");
    
    //DEFININDO POSIÇÕES
    rotulo1.setBounds(50,20,100,20);
    rotulo2.setBounds(50,60,100,20);
    texto1.setBounds(120,20,200,20);
    texto2.setBounds(120,60,200,20);
    exibir.setBounds(50,140,200,20);
    subtrair.setBounds(150,100,80,20);
    
    //SOMANDO
    subtrair.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
    int numero1, numero2, subtrair;
    subtrair = 0;
    
    numero1 = Integer.parseInt(texto1.getText());
    numero2 = Integer.parseInt(texto2.getText());
    
    subtrair = numero1 - numero2;
    
    exibir.setVisible(true);
    exibir.setText("A subtração é: "+subtrair);
        }
    }
);
    //ADICIONANDO A TELA
    exibir.setVisible(false);
    tela1.add(rotulo1);
    tela1.add(rotulo2);
    tela1.add(texto1);
    tela1.add(texto2);
    tela1.add(exibir);
    tela1.add(subtrair);

    //BOTÃO SAIR
    voltar = new JButton("Voltar");
    voltar.setBounds(50,200,100,20);
    
    tela1.add(voltar);
    
    //SAINDO
    voltar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
       dispose();
        }
    }
);
    
    //BOTÃO LIMPAR
    limpar = new JButton("Limpar");
    limpar.setBounds(150,200,100,20);
    tela1.add(limpar);

    //LIMPANDO
    limpar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        texto1.setText(null);
        texto2.setText(null);
        exibir.setText(null);
                }
            }
        );
    
    setSize(400,300);
    setLocationRelativeTo(null);
                        }    
                    }
    
//-----------------------------------------------------------
    private class DivisaoJanela extends JDialog{
    JButton voltar, limpar, dividir;//DECLARANDO JBUTTON'S
    JLabel img, rotulo1, rotulo2, exibir;//DECLARANDO JLABEL'S
    JTextField texto1, texto2;//DECLARANDO JTEXTFIELD'S
 
    
    public DivisaoJanela(Frame owner, String title,boolean modal)
    {
    super(owner,title,modal);
    Container tela1 = getContentPane();
    tela1.setLayout(null);
    
    //ADICIONANDO O ICONE
      ImageIcon icone = new ImageIcon("divisao.png");
       setIconImage(icone.getImage());
      
    //ATRIBUINDO OS VALORES
    rotulo1 = new JLabel("1º Número: ");
    rotulo2 = new JLabel("2º Número: ");
    texto1 = new JTextField(5);
    texto2 = new JTextField(5);
    exibir = new JLabel("");
    dividir = new JButton("Dividir");
    
    //DEFININDO POSIÇÕES
    rotulo1.setBounds(50,20,100,20);
    rotulo2.setBounds(50,60,100,20);
    texto1.setBounds(120,20,200,20);
    texto2.setBounds(120,60,200,20);
    exibir.setBounds(50,140,200,20);
    dividir.setBounds(150,100,80,20);
    
    //SOMANDO
    dividir.addActionListener(
        new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
    int numero1, numero2, dividir;
    dividir = 0;
    
    numero1 = Integer.parseInt(texto1.getText());
    numero2 = Integer.parseInt(texto2.getText());
    
    dividir = numero1 / numero2;
    
    exibir.setVisible(true);
    exibir.setText("A Divisão é: "+dividir);
        }
    }
);
    //ADICIONANDO A TELA
    exibir.setVisible(false);
    tela1.add(rotulo1);
    tela1.add(rotulo2);
    tela1.add(texto1);
    tela1.add(texto2);
    tela1.add(exibir);
    tela1.add(dividir);

    //BOTÃO SAIR
    voltar = new JButton("Voltar");
    voltar.setBounds(50,200,100,20);
    tela1.add(voltar);
    
    //SAINDO
    voltar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
       dispose();
        }
    }
);
    
    //BOTÃO LIMPAR
    limpar = new JButton("Limpar");
    limpar.setBounds(150,200,100,20);
    tela1.add(limpar);

    //LIMPANDO
    limpar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
        texto1.setText(null);
        texto2.setText(null);
        exibir.setText(null);
                }
            }
        );
    
    setSize(400,300);
    setLocationRelativeTo(null);
                        }    
                    }
    
//-------------------------------------------------------    
    private class SobreJanela extends JDialog{
    JLabel rotulo1, rotulo2, rotulo3;
    JButton voltar;
    
    public SobreJanela(Frame owner, String title,boolean modal)
    {
    super(owner,title,modal);
    Container tela1 = getContentPane();
    tela1.setLayout(null);
    
    //ADICIONANDO O ICONE
      ImageIcon icone = new ImageIcon("sobre.png");
       setIconImage(icone.getImage());
    
    rotulo1 = new JLabel("Feito por : Gabrielly Nascimento Bento");
    //PERSONALIZANDO A FONTE
       rotulo1.setFont(new Font("Times New Roman",Font.PLAIN,16));
       
    rotulo2 = new JLabel("2 DS/AMS");
     //PERSONALIZANDO A FONTE
           rotulo2.setFont(new Font("Times New Roman",Font.BOLD,16));

    rotulo3 = new JLabel("Data de Entega: 26/06/2024");
     //PERSONALIZANDO A FONTE
           rotulo3.setFont(new Font("Arial",Font.PLAIN,16));
           
   
     
    //defini a posição dos rotulos
        //- coluna -linha - largura -comprimento 
    rotulo1.setBounds(20,10,500,100);
    rotulo2.setBounds(20,30,500,100);
    rotulo3.setBounds(20,60,500,100);
    
    tela1.add(rotulo1);
    tela1.add(rotulo2);
    tela1.add(rotulo3);
    
    //BOTÃO VOLTAR
    voltar = new JButton("Voltar");
    voltar.setBounds(70,200,100,20);
    tela1.add(voltar);
    
    //VOLTANDO
    voltar.addActionListener(
    new ActionListener(){
    public void actionPerformed(ActionEvent e){
       dispose();
        }
    }
);
    
    setSize(300,300);
    setLocationRelativeTo(null);
                        }    
                    }
        
}//Fim da Classe Lista12
            
        


