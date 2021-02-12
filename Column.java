import java.util.*;



public class Column {
    public int ID;
    public String status;
    public int amountOfFloors;
    public int amountOfElevators;
    public List<Elevator> elevatorsList;
    public List<CallButton> callButtonsList;
    public List<Integer> servedFloorsList;
    public int callButtonId = 1;


       public Column(int _id, String _status, int _amountOfFloors, int _amountOfElevators, List<Integer> _servedFloors, boolean _isBasement)
       {
            this.ID = _id;
            this.status = _status;
            this.amountOfFloors = _amountOfFloors;
            this.amountOfElevators = _amountOfElevators;
            this.servedFloorsList = _servedFloors;
            this.elevatorsList = new ArrayList<Elevator>();
            this.callButtonsList = new ArrayList<CallButton>();

            createElevators(_amountOfFloors, _amountOfElevators);
            createCallbuttons(_amountOfFloors, _isBasement);
       }
        // creating my call buttons
       public void createCallbuttons(int _amountOfFloors, boolean _isBasement)
       {
           
           if (_isBasement)
           {
               int buttonFloor = -1;
               for (int i = 0; i < _amountOfFloors; i++)
               {
                   CallButton callButton = new CallButton(Global.callButtonID, "off", buttonFloor, "Up");
                   this.callButtonsList.add(callButton);
                   buttonFloor --;
                   Global.callButtonID ++;
               }
           }else 
           {
               int buttonFloor = 1;
               for (int i = 0; i < _amountOfFloors; i++)
               {
                   CallButton callButton = new CallButton(Global.callButtonID, "off", buttonFloor, "Down");
                   this.callButtonsList.add(callButton);
                   buttonFloor ++;
                   Global.callButtonID ++;
               }
           }
       }

        // creating my elevator
       public void createElevators(int _amountOfFloors, int _amountOfElevators)
       {
           for ( int i = 0; i < _amountOfElevators; i++)
           {
               Elevator elevator = new Elevator(Global.elevatorID, "idle", _amountOfFloors, 1);
               this.elevatorsList.add(elevator);
               Global.elevatorID ++;
           }
       }

       // to find the best elevator for the request
           public  Elevator findElevator(int floor, String direction)
           {
        
                
                BestElevatorInformation bestElevatorInformation = new BestElevatorInformation();
                bestElevatorInformation.bestElevator=  null;
                bestElevatorInformation.bestScore = 6;
                bestElevatorInformation.referenceGap = 10000000;
                // asking to go back to lobby
                
                if(floor == 1){

                    for(Elevator elevator : this.elevatorsList){
                    
                
                        if (floor == elevator.currentFloor && elevator.status == "idle"){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(1, elevator, bestElevatorInformation, floor);

                        }else if (floor > elevator.currentFloor && elevator.direction == "Up" ){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(2, elevator, bestElevatorInformation, floor);

                        }else if (floor < elevator.currentFloor && elevator.direction == "Down"){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(2, elevator, bestElevatorInformation, floor);

                        }else if (elevator.status == "idle"){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(3, elevator, bestElevatorInformation, floor);
                        }else{

                            bestElevatorInformation = this.checkIfElevatorIsBetter(4, elevator, bestElevatorInformation, floor);

                        }
                        
                    }
                    return bestElevatorInformation.bestElevator;

                } else {
                    for(Elevator elevator : this.elevatorsList){
                    
                
                        if (floor == elevator.currentFloor && elevator.status == "idle"){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(1, elevator, bestElevatorInformation, floor);

                        }else if (floor > elevator.currentFloor && elevator.direction == "Up" && direction == elevator.direction){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(2, elevator, bestElevatorInformation, floor);

                        }else if (floor < elevator.currentFloor && elevator.direction == "Down" && direction == elevator.direction){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(2, elevator, bestElevatorInformation, floor);

                        }else if (elevator.status == "idle"){

                            bestElevatorInformation = this.checkIfElevatorIsBetter(3, elevator, bestElevatorInformation, floor);
                        }else{
                            bestElevatorInformation = this.checkIfElevatorIsBetter(4, elevator, bestElevatorInformation, floor);
                        }
                        
                    }
                    //bestElevatorInformation.bestElevator.floorRequestList.Add(1);
                    return bestElevatorInformation.bestElevator;
                }
            }

        //checking witch elevator is better with the call BestElevatorInformation
        public BestElevatorInformation checkIfElevatorIsBetter(int scoreToCheck,Elevator newElevator, BestElevatorInformation bestElevatorInformation, int floor) 
        {
            //System.Console.WriteLine(scoreToCheck + "the score i am getting");
            
            if (scoreToCheck < bestElevatorInformation.bestScore){
                bestElevatorInformation.bestScore = scoreToCheck;
                bestElevatorInformation.bestElevator = newElevator;
                bestElevatorInformation.referenceGap = Math.abs(newElevator.currentFloor - floor);

            }else if (bestElevatorInformation.bestScore == scoreToCheck)
            {
                int gap = Math.abs(newElevator.currentFloor - floor);
                if (bestElevatorInformation.referenceGap > gap){
                    bestElevatorInformation.bestElevator = newElevator;
                    bestElevatorInformation.referenceGap = gap;
                }
            }
                
            return bestElevatorInformation;
        }


        // requestion my elevator
        public void requestElevator(int floor, String direction)
        {
            System.out.println("column "+ Integer.toString(this.ID));
            String going = "not";
            Elevator elevator = this.findElevator(floor, direction);
            System.out.println("elevator " + Integer.toString(elevator.ID));
            elevator.floorRequestList.add(floor);
            elevator.sortFloorList(going);
            elevator.move();
                   
        }
    
}
