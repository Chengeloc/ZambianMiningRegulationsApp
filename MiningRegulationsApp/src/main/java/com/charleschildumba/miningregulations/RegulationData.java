package com.charleschildumba.miningregulations;

import java.util.ArrayList;
import java.util.List;

public class RegulationData {
    
    public static List<MiningRegulation> getAllRegulations() {
        List<MiningRegulation> regulations = new ArrayList<>();
        
        regulations.add(new MiningRegulation(
            "102",
            "Chief Executive Officer or General Manager (Holder)",
            "Board of Directors / Mining Rights Holder",
            "1. To Appoint Mine Manager: M.R. 202(1)\n" +
            "2. To Appoint Holder E.R.103(1)\n" +
            "3. To provide means to the Mine Manager: for enforcing Regulations M.R. 205(2)\n" +
            "4. To provide means to the Holder under the Explosives Act / Explosives Regulations (E.R.): for enforcing regulations E.R.103(2)"
        ));
        
        regulations.add(new MiningRegulation(
            "202(1)",
            "Mine Manager",
            "Chief Executive Officer or General Manager (Holder)",
            "1. To CONTROL, and provide SUPERVISION and DIRECTION (CSD): M.R.202(1)\n" +
            "2. To CONTROL, and provide SUPERVISION and DIRECTION (CSD) in operations involving explosives: E.R.103(1)\n" +
            "3. To observe and enforce regulations. [M.R.205(1)]\n" +
            "4. To observe and enforce regulations (E.R.104)\n" +
            "5. To make appointments of Competent Persons (Assistants): M.R.204(1); 204(2); 204(3)\n" +
            "6. To make appointments of Competent persons (Assistants): (E.R.105 and E.R.106)"
        ));
        
        regulations.add(new MiningRegulation(
            "204(1)/204(3)",
            "Assistant Manager / Superintendent",
            "Mine Manager (To Assist him / her)",
            "1. Same as (1), (2), (3) and (4) above for the Manager / Holder [M.R. 202(1)] for the particular area of responsibility:\n" +
            "2. To make appointments of competent persons to assist under: M.R.207 and M.R.208 and E.R.108X\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "207 Read with 208(1)",
            "Mine Captain",
            "Assistant Manager / Superintendent",
            "1. Same as that of (appointing authority) i.e. Assistant Manager [204(1)] / Superintendent [204(3)] for the particular area of responsibility but should be mindful of requirements of M.R.208(4) to inspect at least once in each week every place of the section allocated to him in which men work.\n" +
            "2. To make appointments of subordinates\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "207 Read with 208(2)",
            "Competent Person",
            "Assistant Manager / Superintendent",
            "1. Same as that of (appointing authority) i.e. Assistant Manager [204(1)] / Superintendent [204(3)] for the particular area of responsibility but should be mindful of requirements of M.R. 208(4) to inspect at least once in each week every place of the section allocated to him in which men work.\n" +
            "2. To make appointments of subordinates.\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "209(1)",
            "Electrical Engineer / Electrician",
            "Mine Manager or 204(3) Appointee",
            "1. To supervise and effect the proper INSTALLATION, TESTING, EXAMINATION AND MAINTENANCE (ITEM) of all ELECTRICAL APPARATUS as provided for under Mining Regulation 209; (1), (2), (3) and (4).\n" +
            "2. To make appointments of subordinate engineers, electricians in charge or electricians.\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise.\n" +
            "Note: Any subordinate engineer shall (if clearly defined in his letter of appointment) have the same responsibility under the Mining Regulations as the electrical engineer in general charge."
        ));
        
        regulations.add(new MiningRegulation(
            "210(1)",
            "Mechanical Engineer / Subordinate Engineer",
            "Mine Manager or 204(3) Appointee",
            "1. To supervise and effect the proper INSTALLATION, TESTING, EXAMINATION AND MAINTENANCE (ITEM) of all MECHANICAL APPARATUS as provided for under Mining Regulation 210; (1), (2), (3) and (4).\n" +
            "2. To make appointments of subordinate engineers or other competent persons.\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise.\n" +
            "Note: Any subordinate engineer shall (if clearly defined in his letter of appointment) have the same responsibility under the Mining Regulations as the mechanical engineer in general charge."
        ));
        
        regulations.add(new MiningRegulation(
            "211(a)",
            "Chief Surveyor",
            "Mine Manager",
            "1. Carry out the provisions of Part V under the Mining Regulations.\n" +
            "2. To make appointments of subordinates if authorised by appointing authority (there is no explicit provision that authorises 211(a) appointees to make appointments under the regulations)\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "211(b)",
            "Ventilation Engineer",
            "Mine Manager",
            "1. Carry out the provisions of Part IX under the Mining Regulations.\n" +
            "2. To make appointments of subordinates if authorised by appointing authority (there is no explicit provision that authorises 211(b) appointees to make appointments under the regulations)\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "213(1)",
            "Shift Boss",
            "Mine Captain / Competent Person 207 / 208(2)",
            "1. Area of responsibility same as that of Mine Captain for the particular area of responsibility and should be mindful of requirements of M.R.213(4) to examine at least once during his shift every place in the section assigned to him in which any person is working and at least once in each week examine every place in such section through which any person may have occasion to pass.\n" +
            "2. To make appointments of subordinates.\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "214(1)",
            "Shift Foreman",
            "Mine Captain / Competent Person 207 / 208(2)",
            "1. Area of responsibility same as that of Competent Person (Section Engineer) for the particular area of responsibility and should be mindful of requirements of M.R.214(4) to examine at least once during his shift every place in the section assigned to him in which any person is working, or machinery is operating\n" +
            "2. To make appointments of subordinates.\n" +
            "3. To observe, supervise and enforce regulations as per appointment premise."
        ));
        
        regulations.add(new MiningRegulation(
            "215(1)/216",
            "Person in Charge (PIC)",
            "Shift Boss / Shift Foreman",
            "1. Carry out the provisions of M.R.215(1) to (10) and should be mindful of requirements of M.R.215(10) not to take charge of more working places or persons that he can supervise efficiently or take charge of working places so scattered that he cannot examine them all within a period of one hour without undue exertion.\n" +
            "2. To observe, supervise and enforce regulations as per appointment premise M.R.215(1) or M.R.216."
        ));
        
        return regulations;
    }
    
    public static List<MiningRegulation> searchRegulations(String query) {
        List<MiningRegulation> allRegulations = getAllRegulations();
        List<MiningRegulation> results = new ArrayList<>();
        
        String lowerQuery = query.toLowerCase();
        
        for (MiningRegulation regulation : allRegulations) {
            if (regulation.getPosition().toLowerCase().contains(lowerQuery) ||
                regulation.getRegulation().toLowerCase().contains(lowerQuery) ||
                regulation.getAppointedBy().toLowerCase().contains(lowerQuery) ||
                regulation.getLegalResponsibility().toLowerCase().contains(lowerQuery)) {
                results.add(regulation);
            }
        }
        
        return results;
    }
}

