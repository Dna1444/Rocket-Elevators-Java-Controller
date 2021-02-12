import java.util.*;

public class Elevator {
    public int ID;
        public String status;
        public int amountOfFloors;
        public int currentFloor;
        public List<Integer> floorRequestList;
        public String direction;
        public Door door;

        // my contructor
        public Elevator(int _id, String _status, int _amountOfFloors, int _currentFloor)
        {
            this.ID = _id;
            this.status = _status;
            this.amountOfFloors = _amountOfFloors;
            this.currentFloor = _currentFloor;
            this.door = new Door(_id, "close");
            this.floorRequestList = new ArrayList<Integer>();
            this.direction = "none";
            
        }
        

        // moving the elevator to the right floor
        public void move()
        {
            while (this.floorRequestList.size() != 0){
                int destination = this.floorRequestList.get(0);
                this.status = "moving";
                
                System.out.println("this elevator " + Integer.toString(this.ID) + " is moving");
                if (this.currentFloor < destination){  // if statement so if the elevator need to go up it will 
                    
                    System.out.println("this elevator " + Integer.toString(this.ID) + " is going up");
                    this.direction = "up";
                    while (this.currentFloor < destination)
                    {
                        this.currentFloor ++;
                        System.out.println("this elevator " + Integer.toString(this.ID) + " moving to floor " +  Integer.toString(this.currentFloor));
                    
                    }
                }
                else if (this.currentFloor > destination){
                    System.out.println("this elevator " + Integer.toString(this.ID) + " is going down");
                    this.direction = "down";
                    while (this.currentFloor > destination){
                        this.currentFloor --;
                        System.out.println("this elevator " + Integer.toString(this.ID) + " moving to floor " +  Integer.toString(this.currentFloor));
                    }
                }
                
                this.status = "idle";
                this.direction = "null";
                System.out.println("this elevator " + Integer.toString(this.ID) + " is stop");
                this.operateDoors();  // operate door once finish moving
                this.floorRequestList.remove(0);
            
            }
        }

        // my sorting list 
        public void sortFloorList(String going)
        {
            //using lobby to tell that the request is from lobby and change the way it sorted
            if (going == "lobby") 
            {
                if (this.direction == "Down")
                {

                    Collections.sort(this.floorRequestList); 
                }
                else
                {
                    Collections.sort(this.floorRequestList);
                    Collections.reverse(this.floorRequestList);
                }
            }
            // not from lobby use this way of sorting
            else if (going == "not")  
            {
                if (this.direction == "Up")
                {
                    //System.Console.WriteLine("normal sort");
                    Collections.sort(this.floorRequestList); 
                }
                else
                {
                    //System.Console.WriteLine("reverse sort");
                    Collections.sort(this.floorRequestList);
                    Collections.reverse(this.floorRequestList);
                }
            }
        
        }


        // a simple way to open and close doors
        public void operateDoors()
        {

            this.door.status = "open";
            System.out.println("door is " + this.door.status);
            System.out.println("please wait 5 seconds");
            this.door.status = "close";
            System.out.println("door is " + this.door.status);

        }

    
}
