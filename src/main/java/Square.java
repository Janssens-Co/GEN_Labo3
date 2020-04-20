/**
 *  _____ _____ _   _       _      ___ ______ _____ _____
 * |  __ |  ___| \ | |  _  | |    / _ \| ___ |  _  |____ |
 * | |  \| |__ |  \| | (_) | |   / /_\ | |_/ | | | |   / /
 * | | __|  __|| . ` |     | |   |  _  | ___ | | | |   \ \
 * | |_\ | |___| |\  |  _  | |___| | | | |_/ \ \_/ .___/ /
 *  \____\____/\_| \_/ (_) \_____\_| |_\____/ \___/\____/
 *
 * AUTHORS : Mattei Simon, Janssens Emmanuel, Potet Bastien
 */

import java.security.InvalidParameterException;

public abstract class Square {

    String name = "square";

    public Square(){}
    public Square(String name)
    {
        if(name==null || name.equals(""))
        {
            throw new InvalidParameterException("Square name should not be empty");
        }
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public abstract void LandedOn(Player p);

    public String toString()
    {
        return name;
    }
}