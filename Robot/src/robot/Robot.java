package robot;

import robot.connection.RobotConnection;
import robot.connection.RobotConnectionManager;
import robot.connection.exception.RobotConnectionException;

import java.util.Random;

public class Robot {

    private Random rand = new Random();
    private int x = rand.nextInt();
    private int y = rand.nextInt();

    public Direction getDirection() {
        // текущее направление взгляда
        return rand.nextBoolean() ? Direction.RIGHT : Direction.LEFT;
    }

    public int getX() {
        // текущая координата X
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public static void moveRobotTo(Robot robot, int toX, int toY) {
        int deltaX = Math.abs(toX - robot.getX());
        int deltaY = Math.abs(toY - robot.getY());
        if (toX < robot.getX()) {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnRight();
            }
        } else {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
        }
        for (int i = 0; i < deltaX; i++) {
            robot.stepForward();
        }
        if (toY < robot.getY()) {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnRight();
            }
        } else {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
        }
        for (int i = 0; i < deltaY; i++) {
            robot.stepForward();
        }
    }

    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean moved = false;
        for (int i = 0; i < 3 && !moved; i++) {
            RobotConnection newConnection;
            try {
                newConnection = robotConnectionManager.getConnection();
                try {
                    newConnection.moveRobotTo(toX, toY);
                    moved = true;
                    newConnection.close();
                } catch (RobotConnectionException exc) {
                    newConnection.close();
                    // ignore
                } catch (RuntimeException exc) {
                    newConnection.close();
                    throw exc;
                }
            }
            catch (RobotConnectionException exc) {
                // ignore
            }
            catch (RuntimeException exc) {
                throw exc;
            }
        }
        if (!moved) {
            throw new RobotConnectionException("Cannot move after three attempts");
        }
    }

}
