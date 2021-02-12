import java.util.*;


public class Battery {
    public int ID;
    public int amountOfColumns;
    public String status;
    public int amountOfFloors;
    public int amountOfBasements;
    public List<Column> columnList;
    public List<FloorRequestButton> floorButtonsList;
    public List<Integer> servedFloors;
    
    


    public Battery(int _id, int _amountOfColumns, String _status, int _amountOfFloors, int _amountOfBasements, int _amountOfElevatorPerColumn)
    {
        this.ID = _id;
        this.amountOfColumns = _amountOfColumns;
        this.status = _status;
        this.amountOfFloors = _amountOfFloors;
        this.amountOfBasements = _amountOfBasements;
        this.columnList = new ArrayList<Column>();
        this.floorButtonsList = new ArrayList<FloorRequestButton>();


        if (_amountOfBasements > 0)
        {
            createBasementFloorRequestButtons(this.amountOfBasements);
            createBasementColumn(_amountOfBasements, _amountOfElevatorPerColumn);
            this.amountOfColumns --;
        }
        createFloorRequestButtons(this.amountOfFloors);
        createColumns(this.amountOfColumns, this.amountOfFloors, _amountOfElevatorPerColumn);


    }
    // create my basement column
    public void createBasementColumn(int _amountOfBasements, int _amountOfElevatorPerColumn)
    {
        this.servedFloors = new ArrayList<Integer>();
        int floor = -1;
        for ( int i = 0; i < _amountOfBasements; i++)
        {
    
            servedFloors.add(floor);
            floor --;
        }
        
        Column column = new Column(Global.columnID, "online", this.amountOfBasements, _amountOfElevatorPerColumn, servedFloors, true);
        columnList.add(column);
        Global.columnID ++;

    }
    // create my up ground columns
    public void createColumns(int _amountOfColumns, int _amountOfFloors, int _amountOfElevatorPerColumn)
    {
        int amountOfFloorsPerColumn = (int)Math.ceil((double)_amountOfFloors / _amountOfColumns);
        int floor = 1;
        for ( int i = 0; i < _amountOfColumns; i ++)
        {
            this.servedFloors = new ArrayList<Integer>();
            for (int j = 0 ; j < amountOfFloorsPerColumn; j ++)
            {
                if(floor <= _amountOfFloors)
                {
                    if(floor != 1)
                    {
                        this.servedFloors.add(1);
                    }
                    this.servedFloors.add(floor);
                    floor++;
                }
            }
            Column column = new Column(Global.columnID, "online", this.amountOfBasements, _amountOfElevatorPerColumn, servedFloors, false);
            this.columnList.add(column);
            Global.columnID++;
        }
    }

    // making my floor request list
    public void createFloorRequestButtons( int _amountOfFloors)
    {
        int buttonFloor = 1;
        for (int i = 0; i < _amountOfFloors; i++)
        {
            FloorRequestButton floorRequestButton = new FloorRequestButton(Global.floorRequestButtonID, "off", buttonFloor, "Up");
            this.floorButtonsList.add(floorRequestButton);
            buttonFloor ++;
            Global.floorRequestButtonID ++;
        }
    }
    

    //make m y floor request list for basement
    public void createBasementFloorRequestButtons(int _amountOfBasements)
    {
        int buttonFloor = -1;
        for( int i = 0; i < _amountOfBasements; i++)
        {
             FloorRequestButton floorRequestButton = new FloorRequestButton(Global.floorRequestButtonID, "off", buttonFloor, "Down");
             this.floorButtonsList.add(floorRequestButton);
             buttonFloor --;
             Global.floorRequestButtonID ++;
        }
    }   

    // // to pick the column that serve that floor
    public Column findBestColumn(int _requestFloor)
    {
        Column bestColumn = null;
        for(Column column : this.columnList)
        {
            if (column.servedFloorsList.contains(_requestFloor))
            {
                bestColumn = column;
                

            }
            
        }
        return bestColumn;
    }
    
    // chosing the elevator for the request
    public void assignElevator(int _requestFloor, String direction)
    {
        String going = "looby";
        Column column = this.findBestColumn(_requestFloor);
        System.out.println("this column " + Integer.toString(column.ID));
        Elevator elevator = column.findElevator(1, direction);
        System.out.println("this elevator " + Integer.toString(elevator.ID));
        //System.Console.WriteLine("elevator {0}",elevator.ID);
        //elevator.floorRequestList.Add(1);
        //elevator.move();
        elevator.floorRequestList.add(_requestFloor);
        elevator.sortFloorList(going);
        elevator.move();
        
    }


}
    

