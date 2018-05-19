package state;

import java.util.LinkedList;


public interface StateInterface 
{
	int addstate(String State_name);
	LinkedList generateStateList(String state_id,String flag);
	int stateModification(int state_id,String state_name);
	int stateDeletion(int state_id);
	LinkedList megaHuntState(String state_name);

}
