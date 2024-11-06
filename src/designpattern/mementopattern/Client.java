package designpattern.mementopattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-05
 * @Description: 备忘录模式
 * @Version: 1.0
 */
public class Client {
    private static int index=0;
    public static void main(String[] args) {
        ChessOriginator chessOriginator = new ChessOriginator(new ChessMemento("车",0,0));

    }
    public static void move(ChessOriginator chessOriginator){

    }
}

class ChessMemento {
    private String state;
    private int x;
    private int y;

    public ChessMemento(String state, int x, int y) {
        this.state = state;
        this.x = x;
        this.y = y;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getState() {
        return state;
    }
    @Override
    public String toString() {
        return "ChessMemento{" +
                "state='" + state + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}

class ChessOriginator{
    private ChessMemento chessMemento;
    public ChessOriginator(ChessMemento chessMemento) {
        this.chessMemento = chessMemento;
    }
    public ChessMemento getChessMemento() {
        return chessMemento;
    }
    public void setChessMemento(ChessMemento chessMemento) {
        this.chessMemento = chessMemento;
    }
    public void setX(int x) {
        chessMemento.setX(x);
    }
    public void setY(int y) {
        chessMemento.setY(y);
    }
    public ChessMemento createChessMemento() {
        return new ChessMemento(chessMemento.getState(),chessMemento.getX(),chessMemento.getY());
    }
    //悔棋
    public void restoreChessMemento(ChessMemento chessMemento) {
        this.chessMemento.setState(chessMemento.getState());
        this.chessMemento.setX(chessMemento.getX());
        this.chessMemento.setY(chessMemento.getY());
    }
    public void show(){
        System.out.println("棋子状态：" + chessMemento.getState() + "，棋子位置：(" + chessMemento.getX() + "," + chessMemento.getY() + ")");
    }
}

class  ChessCaretaker{
    private List<ChessMemento> chessMementoList = new ArrayList<>();
    public void add(ChessMemento chessMemento) {
        chessMementoList.add(chessMemento);
    }
    public ChessMemento get(int i) {
        return chessMementoList.get(i);
    }

}


