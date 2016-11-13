package com.javarush.test.level13.lesson11.bonus03fixed;

public class BodyPart
{
    final static BodyPart LEG = new BodyPart("нога");
    final static BodyPart HEAD = new BodyPart("голова");
    final static BodyPart ARM = new BodyPart("рука");

    private String bodyPart;

    public BodyPart(String bodyPart)
    {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString()
    {
        return this.bodyPart;
    }
}
