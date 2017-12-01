package game;

/**
 * Created by zU on 2015/3/30.
 */

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

public class GamePanel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public GamePanel() {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 30; j++)
                grid[i][j] = 0;
        }
        setBackground(Color.BLACK);//��ɫ����
        currentBlock = paintPanel.getBlock();
        currentLocation[0] = 9;
        currentLocation[1] = 0;
        locations = currentBlock.getLocation(currentLocation[0], currentLocation[1]);
        flag = false;

    }


    public void paintComponent(Graphics g)//������Ϸ��
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.BLUE);//��ɫ����

        for (int i = 0; i < 20; i++)//��grid������Ϊ1�����򶼻���������
        {
            for (int j = 0; j < 30; j++) {
                if (grid[i][j] == 1) {
                    Rectangle2D rectangle = new Rectangle2D.Double(i * POINT_DISTANCE - 1, j * POINT_DISTANCE - 1, BLOCK_WIDTH, BLOCK_HEIGHT);
                    g2.fill(rectangle);
                }
            }
        }
        //Ȼ���ٽ���ǰ��������������Ϸ��
        for (int i = 0; i < 4; i++) {
            if (locations[i][1] >= 0) {
                Rectangle2D rectangle = new Rectangle2D.Double(locations[i][0] * POINT_DISTANCE - 1, locations[i][1] * POINT_DISTANCE - 1, BLOCK_WIDTH, BLOCK_HEIGHT);
                g2.fill(rectangle);
            }
        }

    }


    //����Ϸ���ƶ�����ĺ���������Ҫ����
    public void move(int direction) {
        //flag==true����ʾ��ǰ����û�л�Ķ�����Ҫ�õ���һ������
        if (flag == true) {
            currentBlock = paintPanel.getBlock();
            currentLocation[0] = 9;
            currentLocation[1] = 0;
            locations = currentBlock.getLocation(currentLocation[0], currentLocation[1]);
            flag = false;
        }
        //��ʾ��ǰ�����л�Ķ���
        //�ж��Ƿ񵽵ף�������������£���ô����ǰ����Ŀ�������ӽ�grid�Ȼ������flagΪtrue
        if (isBottom(locations) == true) {
            flag = true;
            for (int i = 0; i < 4; i++) {
                if (locations[i][1] >= 0)
                    grid[locations[i][0]][locations[i][1]] = 1;
            }
            repaint();
            if (checkOver() == true) {
                MainWindowFrame.stopTimer();
                JOptionPane.showMessageDialog(null, "Game Over");
            }
            return;
        }
        //�ж��Ƿ��������ƶ���������У���ô��ǰ�������yֵ���ٱ仯��������ԣ���yֵ����direction��direction=1��ʾ���ƣ�-1��ʾ���ƣ�0��ʾû�������ƶ�
        if (isEdge(direction) == false) {
            currentLocation[0] += direction;
        }
        if (direction == 0)
            currentLocation[1]++;
        locations = currentBlock.getLocation(currentLocation[0], currentLocation[1]);
        repaint();

    }

    //�ڰ��������µļ���ֱ���Ƶ��ײ��ĺ���
    public void moveToBottom() {

        @SuppressWarnings("unused")
        int i = 0;
        while (isBottom(locations) == false) {
            i++;
            for (int j = 0; j < 4; j++) {
                locations[j][1]++;
            }
        }
        for (int j = 0; j < 4; j++) {
            if (locations[j][1] >= 0) {
                grid[locations[j][0]][locations[j][1]] = 1;
            }
        }
        flag = true;
        repaint();
    }

    //����Ƿ���Ϸ����
    public boolean checkOver() {
        for (int i = 0; i < 4; i++) {
            if (locations[i][1] < 0)
                return true;
        }
        return false;
    }

    //����Ƿ񵽵�
    private boolean isBottom(int[][] l) {
        for (int i = 0; i < 4; i++) {
            if (l[i][1] >= 0 && l[i][0] >= 0 && l[i][0] < 20) {
                if ((l[i][1] + 1) >= 30 || grid[l[i][0]][l[i][1] + 1] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //����Ƿ񵽴��Ե
    private boolean isEdge(int direction) {
        for (int i = 0; i < 4; i++) {
            if (locations[i][1] >= 0) {
                if ((locations[i][0] + direction) >= 20 || (locations[i][0] + direction) < 0 || grid[locations[i][0] + direction][locations[i][1]] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //�������Ƿ����������ҽ������д���
    public int checkLine() {
        int lines = 0;

        for (int i = 0; i < 30; i++) {
            int sum = 0;
            for (int j = 0; j < 20; j++) {
                sum += grid[j][i];
            }
            if (sum == 20) {
                lines++;
                for (int k = i; k > 0; k--) {
                    for (int h = 0; h < 20; h++) {
                        grid[h][k] = grid[h][k - 1];
                    }
                }
                for (int k = 0; k < 20; k++) {
                    grid[k][0] = 0;
                }
                i--;
                repaint();
            }


        }
        return lines;

    }


    //�ı䷽����̬�ĺ���������Ҫ�ı���̬����Ҫ���ı��ķ����Ƿ�Խ�磬���Խ�磬��Ҫ���е���
    public void changePosition() {
        currentBlock.changePosition();
        int min = 0;
        int max = 0;
        locations = currentBlock.getLocation(currentLocation[0], currentLocation[1]);
        for (int i = 0; i < 4; i++) {
            if (min > locations[i][0]) {
                min = locations[i][0];
            }
            if (max < locations[i][0]) {
                max = locations[i][0];
            }

        }
        //System.out.println("min:"+min+"  max:"+max);
        if (min < 0) {
            currentLocation[0] += (-min);
        }
        if (max > 19) {
            currentLocation[0] -= (max - 19);
        }
        locations = currentBlock.getLocation(currentLocation[0], currentLocation[1]);
        repaint();
    }

    //������reset����ʱ������GamePanel
    public static void resetGamePanel() {
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 20; j++) {
                grid[j][i] = 0;
            }
        }
        flag = true;
    }

    private static int[][] grid = new int[20][30];//�����洢��Ϸ�����ݵ����飬Ϊ1��ʾ��ǰ���з���,ǰ�������ʾx����һ����ʾy����һ��������е㲻һ��
    private Blocks currentBlock;//Ŀǰ������Ϸ����ķ���
    private int[][] locations;//��ǰ�����ĸ������������
    private int[] currentLocation = new int[]{0, 0};//��ǰ�ο��������
    private int BLOCK_WIDTH = 18;//����ı߳�
    private int BLOCK_HEIGHT = 18;
    private int POINT_DISTANCE = 20;//�����ļ��
    private static boolean flag = true;//Ϊtrueʱ����ʾ��ǰû�л�ķ���

}

