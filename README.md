# Inicjaly

Program wykonany w javie z urzyciem swinga i awk.

Program rysuje moje inicjały wykorzystując krzywe beziera.


Opis kodu:

Klasa Panel:

zaiwera tablicę punktów oraz wartości wykorzystywane przy wyliczaniu wspułżędnych punktów

    Point[] q = new Point[4];
    double k = 0.025,t;
    
konstruktor ustwaiający odpowiednie wartości dla panelu

    public Panel() {
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }
    
  funkcja paint wywołuje funkcję rysuj_krzywe  i ustawia wartości dla punktów kontrolnych
    
     public void paint(Graphics g) {

        //Litera A
        q[0] = new Point(50,400);
        q[1] = new Point(62,420);
        q[2] = new Point(88,420);
        q[3] = new Point(100,400);
        rysuj_krzywa(g,q);

        q[0] = new Point(200,400);
        q[1] = new Point(212,420);
        q[2] = new Point(238,420);
        q[3] = new Point(250,400);
        rysuj_krzywa(g,q);

        q[0] = new Point(100,400);
        q[1] = new Point(137,80);
        q[2] = new Point(163,80);
        q[3] = new Point(200,400);
        rysuj_krzywa(g,q);

        q[0] = new Point(50,400);
        q[1] = new Point(140,10);
        q[2] = new Point(160,10);
        q[3] = new Point(250,400);
        rysuj_krzywa(g,q);

        g.drawLine(115,290,185,290);
        g.drawLine(117,260,183,260);


        //Litera P
        q[0] = new Point(350,400);
        q[1] = new Point(362,420);
        q[2] = new Point(388,420);
        q[3] = new Point(400,400);
        rysuj_krzywa(g,q);

        q[0] = new Point(350,400);
        q[1] = new Point(365,350);
        q[2] = new Point(365,200);
        q[3] = new Point(350,120);
        rysuj_krzywa(g,q);

        q[0] = new Point(400,400);
        q[1] = new Point(380,350);
        q[2] = new Point(380,300);
        q[3] = new Point(389,290);
        rysuj_krzywa(g,q);

        q[0] = new Point(300,120);
        q[1] = new Point(315,125);
        q[2] = new Point(335,125);
        q[3] = new Point(350,120);
        rysuj_krzywa(g,q);

        q[0] = new Point(300,120);
        q[1] = new Point(336,100);
        q[2] = new Point(388,100);
        q[3] = new Point(400,105);
        rysuj_krzywa(g,q);

        q[0] = new Point(400,105);
        q[1] = new Point(530,145);
        q[2] = new Point(532,155);
        q[3] = new Point(390,290);//
        rysuj_krzywa(g,q);

        q[0] = new Point(400,140);
        q[1] = new Point(470,165);
        q[2] = new Point(474,175);
        q[3] = new Point(389,250);
        rysuj_krzywa(g,q);

        q[0] = new Point(400,140);
        q[1] = new Point(380,170);
        q[2] = new Point(380,210);
        q[3] = new Point(389,250);
        rysuj_krzywa(g,q);



    }
    
  funkcja wylicza w pętli na podstawie wzoru miejscanowych punktów i rysuje między nimi proste dzięki czemu powstaje krzywa beziera
    
    public void rysuj_krzywa(Graphics g,Point[] punkty)
    {
        double x1,x2,y1,y2;

        x1 = punkty[0].x;
        y1 = punkty[0].y;

        for(t = k; t <= 1 + k; t += k)
        {
            x2 = (punkty[0].x + t * (-punkty[0].x * 3 + t * (3*punkty[0].x - punkty[0].x * t))) + t * (3 * punkty[1].x + t * (-6*punkty[1].x +
                    punkty[1].x * 3 * t)) + t * t * (punkty[2].x * 3 - punkty[2].x * 3 * t) + punkty[3].x * t * t * t;

            y2 = (punkty[0].y + t * (-punkty[0].y * 3 + t * (3*punkty[0].y - punkty[0].y * t))) + t * (3*punkty[1].y + t * (-6*punkty[1].y +
                    punkty[1].y * 3 * t)) + t * t * (punkty[2].y * 3 - punkty[2].y * 3 * t)+punkty[3].y * t * t * t;

            g.setColor(Color.black);
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);

            x1 = x2;
            y1 = y2;
        }
    }
    
Klasa Okno

konstruktor tworzy obiekt klasy Panel i ustawia odpowiednie wartości dla okna

    public Okno() {
        panel = new Panel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(10,10,600,600);
        this.add(panel);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("litery");

    }
    
Klasa Main

wywołuje obiekt klasy Okno

    public static void main(String[] args) {
	    // write your code here
        Okno o = new Okno();
    }
