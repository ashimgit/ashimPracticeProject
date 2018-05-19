package smetype;

import java.util.LinkedList;

public interface SMETypeInterface {
	int addSMEType(String serviceproviderType_name);
	LinkedList generateSMETypeList(String smetype_id,String flag);
	int smetypeModification(int smetype_id,String smetype_name);
	int smetypeDeletion(int smetype_id);
	LinkedList megaHuntSMEType(String smetype_name);
}
