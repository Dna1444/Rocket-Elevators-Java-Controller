


class Main 
    {

        public static void main(String[] args) {

        }
        public static void Senario1()
            {
                Battery battery = new Battery( 1, 4, "online", 60, 6, 5);
                battery.columnList.get(1).elevatorsList.get(0).currentFloor = 20;
                battery.columnList.get(1).elevatorsList.get(0).status = "moving";
                battery.columnList.get(1).elevatorsList.get(0).direction = "Down";
                battery.columnList.get(1).elevatorsList.get(0).floorRequestList.add(5);
                battery.columnList.get(1).elevatorsList.get(1).currentFloor = 3;
                battery.columnList.get(1).elevatorsList.get(1).status = "moving";
                battery.columnList.get(1).elevatorsList.get(1).direction = "Up";
                battery.columnList.get(1).elevatorsList.get(1).floorRequestList.add(15);
                battery.columnList.get(1).elevatorsList.get(2).currentFloor = 13;
                battery.columnList.get(1).elevatorsList.get(2).status = "moving";
                battery.columnList.get(1).elevatorsList.get(2).direction = "Down";
                battery.columnList.get(1).elevatorsList.get(2).floorRequestList.add(1);
                battery.columnList.get(1).elevatorsList.get(3).currentFloor = 15;
                battery.columnList.get(1).elevatorsList.get(3).status = "moving";
                battery.columnList.get(1).elevatorsList.get(3).direction = "Down";
                battery.columnList.get(1).elevatorsList.get(3).floorRequestList.add(2);
                battery.columnList.get(1).elevatorsList.get(4).currentFloor = 6;
                battery.columnList.get(1).elevatorsList.get(4).status = "moving";
                battery.columnList.get(1).elevatorsList.get(4).direction = "Down";
                battery.columnList.get(1).elevatorsList.get(4).floorRequestList.add(1);
                
                battery.assignElevator(20, "Up");


            }
            public static void Senario2()
            {
                Battery battery = new Battery( 1, 4, "online", 60, 6, 5);
                battery.columnList.get(2).elevatorsList.get(0).currentFloor = 1;
                battery.columnList.get(2).elevatorsList.get(0).status = "idle";
                battery.columnList.get(2).elevatorsList.get(0).direction = "Up";
                battery.columnList.get(2).elevatorsList.get(0).floorRequestList.add(21);
                battery.columnList.get(2).elevatorsList.get(1).currentFloor = 23;
                battery.columnList.get(2).elevatorsList.get(1).status = "moving";
                battery.columnList.get(2).elevatorsList.get(1).direction = "Up";
                battery.columnList.get(2).elevatorsList.get(1).floorRequestList.add(28);
                battery.columnList.get(2).elevatorsList.get(2).currentFloor = 33;
                battery.columnList.get(2).elevatorsList.get(2).status = "moving";
                battery.columnList.get(2).elevatorsList.get(2).direction = "Down";
                battery.columnList.get(2).elevatorsList.get(2).floorRequestList.add(1);
                battery.columnList.get(2).elevatorsList.get(3).currentFloor = 40;
                battery.columnList.get(2).elevatorsList.get(3).status = "moving";
                battery.columnList.get(2).elevatorsList.get(3).direction = "Down";
                battery.columnList.get(2).elevatorsList.get(3).floorRequestList.add(24);
                battery.columnList.get(2).elevatorsList.get(4).currentFloor = 39;
                battery.columnList.get(2).elevatorsList.get(4).status = "moving";
                battery.columnList.get(2).elevatorsList.get(4).direction = "Down";
                battery.columnList.get(2).elevatorsList.get(4).floorRequestList.add(1);
                
                battery.assignElevator(36, "Up");


            }

            public static void Senario3()
            {
                Battery battery = new Battery( 1, 4, "online", 60, 6, 5);
                battery.columnList.get(3).elevatorsList.get(0).currentFloor = 58;
                battery.columnList.get(3).elevatorsList.get(0).status = "moving";
                battery.columnList.get(3).elevatorsList.get(0).direction = "Down";
                battery.columnList.get(3).elevatorsList.get(0).floorRequestList.add(1);
                battery.columnList.get(3).elevatorsList.get(1).currentFloor = 50;
                battery.columnList.get(3).elevatorsList.get(1).status = "moving";
                battery.columnList.get(3).elevatorsList.get(1).direction = "Up";
                battery.columnList.get(3).elevatorsList.get(1).floorRequestList.add(60);
                battery.columnList.get(3).elevatorsList.get(2).currentFloor = 46;
                battery.columnList.get(3).elevatorsList.get(2).status = "moving";
                battery.columnList.get(3).elevatorsList.get(2).direction = "Up";
                battery.columnList.get(3).elevatorsList.get(2).floorRequestList.add(58);
                battery.columnList.get(3).elevatorsList.get(3).currentFloor = 1;
                battery.columnList.get(3).elevatorsList.get(3).status = "moving";
                battery.columnList.get(3).elevatorsList.get(3).direction = "Up";
                battery.columnList.get(3).elevatorsList.get(3).floorRequestList.add(54);
                battery.columnList.get(3).elevatorsList.get(4).currentFloor = 60;
                battery.columnList.get(3).elevatorsList.get(4).status = "moving";
                battery.columnList.get(3).elevatorsList.get(4).direction = "Down";
                battery.columnList.get(3).elevatorsList.get(4).floorRequestList.add(1);

            
                
                battery.columnList.get(3).requestElevator(51, "Down");


            }

            public static void Senario4()
            {
                Battery battery = new Battery( 1, 4, "online", 60, 6, 5);
                battery.columnList.get(0).elevatorsList.get(0).currentFloor = -4;
                battery.columnList.get(0).elevatorsList.get(0).status = "idle";
                battery.columnList.get(0).elevatorsList.get(1).currentFloor = 1;
                battery.columnList.get(0).elevatorsList.get(1).status = "idle";
                battery.columnList.get(0).elevatorsList.get(2).currentFloor = -3;
                battery.columnList.get(0).elevatorsList.get(2).status = "moving";
                battery.columnList.get(0).elevatorsList.get(2).direction = "Down";
                battery.columnList.get(0).elevatorsList.get(2).floorRequestList.add(-5);
                battery.columnList.get(0).elevatorsList.get(3).currentFloor = -6;
                battery.columnList.get(0).elevatorsList.get(3).status = "moving";
                battery.columnList.get(0).elevatorsList.get(3).direction = "Up";
                battery.columnList.get(0).elevatorsList.get(3).floorRequestList.add(1);
                battery.columnList.get(0).elevatorsList.get(4).currentFloor = -1;
                battery.columnList.get(0).elevatorsList.get(4).status = "moving";
                battery.columnList.get(0).elevatorsList.get(4).direction = "Down";
                battery.columnList.get(0).elevatorsList.get(4).floorRequestList.add(-6);

            
                
                battery.columnList.get(0).requestElevator(-3, "Up");


            }

            

            
    }
