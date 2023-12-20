package harpoonDiver.core;

import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static harpoonDiver.common.ConstantMessages.*;
import static harpoonDiver.common.ExceptionMessages.*;


public class ControllerImpl implements Controller{
    private Map<String, Diver> diverRepository;
    private Map<String, String[]> divingSiteRepository ;

    public ControllerImpl() {
        this.diverRepository = new LinkedHashMap<>();
        this.divingSiteRepository = new LinkedHashMap<String, String[]>();
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        if (kind.equals("DeepWaterDiver")){
            diver = new DeepWaterDiver(diverName);
        }else if (kind.equals("OpenWaterDiver")){
            diver = new OpenWaterDiver(diverName);
        }else if (kind.equals("WreckDiver")){
            diver = new WreckDiver(diverName);
        }else{
            throw new IllegalArgumentException(DIVER_INVALID_KIND);
        }

        diverRepository.put(diverName, diver);
        return String.format(DIVER_ADDED, kind , diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        divingSiteRepository.put(siteName, seaCreatures);

        return String.format(DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.get(diverName);
        if (diver == null){
            throw new IllegalArgumentException(String.format(DIVER_DOES_NOT_EXIST, diverName));
        }

        diverRepository.remove(diver);
        return String.format(DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List <Diver> diverList = new ArrayList<>();
        List <Diver> removedDiversList=new ArrayList<>();
        for (String diverName: diverRepository.keySet()){
            Diver diver = diverRepository.get(diverName);
            if (diver.getOxygen() > 30){
                diverList.add(diver);
            }else{
                removedDiversList.add(diver);
            }
        }

        if (diverList.isEmpty()){
            throw new IllegalArgumentException(SITE_DIVERS_DOES_NOT_EXISTS);
        }

        return   String.format(SITE_DIVING, siteName, removedDiversList.size());
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        Diver diver;

        for (String diverName: diverRepository.keySet()) {
             diver = diverRepository.get(diverName);

        }
        sb.append(String.format("The dive took place at %d site/s.", divingSiteRepository.keySet().size()));
        sb.append(System.lineSeparator());
        sb.append("Diver's statistics:");
        sb.append(System.lineSeparator());
        sb.append("Name: ");

















        return null;
    }
}
