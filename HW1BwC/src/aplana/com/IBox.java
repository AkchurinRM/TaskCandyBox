package aplana.com;

public interface IBox{
    public void add(Candy candy) throws WrongArgumentException;
    public void remove_by_weight(short weight) throws WrongArgumentException;
    public void remove_by_ID(long id) throws WrongArgumentException;
    public void showInfo();
}
