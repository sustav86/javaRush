package com.javarush.test.level15.lesson12.home05;

/**
 * Created by ukr-sustavov on 25.09.2015.
 */
public class SubSolution extends Solution
{
    public SubSolution(String str)
    {
        super(str);
    }

    public SubSolution(Integer num)
    {
        super(num);
    }

    public SubSolution(Double dub)
    {
        super(dub);
    }

    SubSolution(Character ch)
    {
        super(ch);
    }

    SubSolution(Character ch, String str)
    {
        super(ch, str);
    }

    SubSolution(Character ch, int num)
    {
        super(ch, num);
    }

    protected SubSolution(String dtr, Integer num)
    {
        super(dtr, num);
    }

    protected SubSolution(String dtr, Integer num, Double db)
    {
        super(dtr, num, db);
    }

    protected SubSolution(String dtr, Integer num, Double db, Character ch)
    {
        super(dtr, num, db, ch);
    }

    private SubSolution(int num) {

        super(num);

    }

    private SubSolution(double dub) {

        super(dub);

    }

    private SubSolution(char ch) {

        super(ch);

    }
}
