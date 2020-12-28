import java.util.*;

import java.io.*;

import java.math.*;



/**

 * Auto-generated code below aims at helping you parse

 * the standard input according to the problem statement.

 **/


class Player
{


    /* IL FAUT CREER UN ENUMERATEUR */

    static  boolean[][] abMatrix = new boolean[30][20];

    static int s32CountUp = 0;
    static int s32CountDown = 0;
    static int s32CountLeft = 0;
    static int s32CountRight = 0;



    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /* Initialize matrix with false (not occupied) */
        for (int i = 0; i < 30; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                abMatrix[i][j] = false;
            }
        }


        // game loop

        while (true)
        {

            int N = in.nextInt(); // total number of players (2 to 4).

            int P = in.nextInt(); // your player number (0 to 3).
            /* Current position */
            int s32PrevX = 0;
            int s32PrevY = 0;
            int s32CurrX = 0;
            int s32CurrY = 0;
            /* 0 = up, 1 = down, 2 = left, 3 right, 4 unknown */
            int s32Dir = 4;

            for (int i = 0; i < N; i++)
            {

                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)

                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)

                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)

                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)

                if (   (X1 != -1)
                        && (Y1 != -1))
                {
                    abMatrix[X1][Y1] = true;
                }

                /* Refresh current position */
                if (i == P)
                {
                    s32PrevX = s32CurrX;
                    s32PrevY = s32CurrY;
                    s32CurrX = X1;
                    s32CurrY = Y1;

                    if  (s32PrevX < s32CurrX)
                    {
                        s32Dir = 3;
                    }
                    else if (s32PrevX > s32CurrX)
                    {
                        s32Dir = 2;
                    }
                    else if (s32PrevY < s32CurrY)
                    {
                        s32Dir = 1;
                    }
                    else if (s32PrevY > s32CurrY)
                    {
                        s32Dir = 0;
                    }
                    /* Supposed to happend only at first round */
                    else
                    {
                        s32Dir = 4;
                    }
                }
            }

            do
            {
                if ((s32CurrY - s32CountUp - 1) <= 0)
                {
                    break;
                }
                else if (abMatrix[s32CurrX][s32CurrY - s32CountUp - 1]) /* is true */
                {
                    break;
                }
                s32CountUp = s32CountUp + 1;
            }   while (s32CountUp < 20);


                do
                {
                    if ((s32CurrY + s32CountDown + 1) >= 20)
                    {
                        break;
                    }
                    else if (abMatrix[s32CurrX][s32CurrY + s32CountDown + 1]) /*is true */
                    {
                        break;
                    }

                    s32CountDown = s32CountDown + 1;
                }   while (s32CountDown < 20);

                do
                {
                    if ((s32CurrX + s32CountRight + 1) >= 30)
                    {
                        break;
                    }
                    else if (abMatrix[s32CurrX + s32CountRight + 1][s32CurrY]) /*is true */
                    {
                        break;
                    }
                    s32CountRight = s32CountRight + 1;
                }   while (s32CountRight < 20);

                do
                {
                    if ((s32CurrX - s32CountLeft - 1) >= 30)
                    {
                        break;
                    }
                    else if (abMatrix[s32CurrX - s32CountLeft - 1][s32CurrY]) /* is true */
                    {
                        break;
                    }
                    s32CountLeft = s32CountLeft + 1;
                }   while (s32CountLeft < 20);



                /* Dir unknown == init devrait être une fonction avec dir et count en para */
                if (s32Dir == 4) {


                    if ((s32CountUp >= s32CountDown)
                            && (s32CountUp >= s32CountLeft)
                            && (s32CountUp >= s32CountRight)) {
                        System.out.println("UP");
                    } else if ((s32CountDown >= s32CountUp)
                            && (s32CountDown >= s32CountLeft)
                            && (s32CountDown >= s32CountRight)) {
                        System.out.println("DOWN");
                    } else if ((s32CountLeft >= s32CountUp)
                            && (s32CountLeft >= s32CountDown)
                            && (s32CountLeft >= s32CountRight)) {
                        System.out.println("LEFT");
                    } else if (s32CountRight >= s32CountDown) {
                        System.out.println("RIGHT");
                    } else {
                        System.out.println("RIGHT");
                    }
                }
                /* Up */
                else if (s32Dir == 0) {
                    if ((s32CountUp >= s32CountDown)
                            && (s32CountUp >= s32CountLeft)
                            && (s32CountUp >= s32CountRight)) {
                        System.out.println("UP");
                    } else if ((s32CountLeft >= s32CountUp)
                            && (s32CountLeft >= s32CountDown)
                            && (s32CountLeft >= s32CountRight)) {
                        System.out.println("LEFT");
                    } else if ((s32CountRight >= s32CountUp)
                            && (s32CountRight >= s32CountLeft)
                            && (s32CountRight >= s32CountDown)) {
                        System.out.println("RIGHT");
                    } else {
                        System.out.println("RIGHT");
                    }
                }
                /* Down */
                else if (s32Dir == 1) {
                    if ((s32CountDown >= s32CountUp)
                            && (s32CountDown >= s32CountLeft)
                            && (s32CountDown >= s32CountRight)) {
                        System.out.println("DOWN");
                    } else if ((s32CountLeft >= s32CountUp)
                            && (s32CountLeft >= s32CountDown)
                            && (s32CountLeft >= s32CountRight)) {
                        System.out.println("LEFT");
                    } else if (s32CountRight >= s32CountUp) {
                        System.out.println("RIGHT");
                    } else {
                        System.out.println("RIGHT");
                    }
                }
                /* left */
                else if (s32Dir == 2) {
                    if ((s32CountUp >= s32CountDown)
                            && (s32CountUp >= s32CountLeft)
                            && (s32CountUp >= s32CountRight)) {
                        System.out.println("UP");
                    } else if ((s32CountDown >= s32CountUp)
                            && (s32CountDown >= s32CountLeft)
                            && (s32CountDown >= s32CountRight)) {
                        System.out.println("DOWN");
                    } else if ((s32CountLeft >= s32CountUp)
                            && (s32CountLeft >= s32CountDown)
                            && (s32CountLeft >= s32CountRight)) {
                        System.out.println("LEFT");
                    } else {
                        System.out.println("RIGHT");
                    }
                }
                /* right */
                else if (s32Dir == 3) {
                    if ((s32CountUp >= s32CountDown)
                            && (s32CountUp >= s32CountLeft)
                            && (s32CountUp >= s32CountRight)) {
                        System.out.println("UP");
                    } else if ((s32CountDown >= s32CountUp)
                            && (s32CountDown >= s32CountLeft)
                            && (s32CountDown >= s32CountRight)) {
                        System.out.println("DOWN");
                    } else if (s32CountRight >= s32CountUp && s32CountRight >= s32CountLeft) {
                        System.out.println("RIGHT");
                    } else {
                        System.out.println("RIGHT");
                    }
                }
            }
                /* Throw exception method must be added */
        }
    }
