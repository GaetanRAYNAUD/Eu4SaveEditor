package fr.graynaud.eu4saveeditor.service.object.save;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.graynaud.eu4saveeditor.common.ParseUtils;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Religions implements Parsable {

    private Religion noReligion;

    private Religion catholic;

    private Religion anglican;

    private Religion protestant;

    private Religion reformed;

    private Religion orthodox;

    private Religion coptic;

    private Religion sunni;

    private Religion shiite;

    private Religion ibadi;

    private Religion buddhism;

    private Religion vajrayana;

    private Religion mahayana;

    private Religion confucianism;

    private Religion shinto;

    private Religion hinduism;

    private Religion sikhism;

    private Religion animism;

    private Religion shamanism;

    private Religion totemism;

    private Religion inti;

    private Religion nahuatl;

    private Religion mesoamericanReligion;

    private Religion norsePaganReformed;

    private Religion tengriPaganReformed;

    private Religion jewish;

    private Religion zoroastrian;

    public Religions() {
    }

    public Religions(String content) {
        parse(content);
    }

    public Religion getNoReligion() {
        return noReligion;
    }

    public void setNoReligion(Religion noReligion) {
        this.noReligion = noReligion;
    }

    public Religion getCatholic() {
        return catholic;
    }

    public void setCatholic(Religion catholic) {
        this.catholic = catholic;
    }

    public Religion getAnglican() {
        return anglican;
    }

    public void setAnglican(Religion anglican) {
        this.anglican = anglican;
    }

    public Religion getProtestant() {
        return protestant;
    }

    public void setProtestant(Religion protestant) {
        this.protestant = protestant;
    }

    public Religion getReformed() {
        return reformed;
    }

    public void setReformed(Religion reformed) {
        this.reformed = reformed;
    }

    public Religion getOrthodox() {
        return orthodox;
    }

    public void setOrthodox(Religion orthodox) {
        this.orthodox = orthodox;
    }

    public Religion getCoptic() {
        return coptic;
    }

    public void setCoptic(Religion coptic) {
        this.coptic = coptic;
    }

    public Religion getSunni() {
        return sunni;
    }

    public void setSunni(Religion sunni) {
        this.sunni = sunni;
    }

    public Religion getShiite() {
        return shiite;
    }

    public void setShiite(Religion shiite) {
        this.shiite = shiite;
    }

    public Religion getIbadi() {
        return ibadi;
    }

    public void setIbadi(Religion ibadi) {
        this.ibadi = ibadi;
    }

    public Religion getBuddhism() {
        return buddhism;
    }

    public void setBuddhism(Religion buddhism) {
        this.buddhism = buddhism;
    }

    public Religion getVajrayana() {
        return vajrayana;
    }

    public void setVajrayana(Religion vajrayana) {
        this.vajrayana = vajrayana;
    }

    public Religion getMahayana() {
        return mahayana;
    }

    public void setMahayana(Religion mahayana) {
        this.mahayana = mahayana;
    }

    public Religion getConfucianism() {
        return confucianism;
    }

    public void setConfucianism(Religion confucianism) {
        this.confucianism = confucianism;
    }

    public Religion getShinto() {
        return shinto;
    }

    public void setShinto(Religion shinto) {
        this.shinto = shinto;
    }

    public Religion getHinduism() {
        return hinduism;
    }

    public void setHinduism(Religion hinduism) {
        this.hinduism = hinduism;
    }

    public Religion getSikhism() {
        return sikhism;
    }

    public void setSikhism(Religion sikhism) {
        this.sikhism = sikhism;
    }

    public Religion getAnimism() {
        return animism;
    }

    public void setAnimism(Religion animism) {
        this.animism = animism;
    }

    public Religion getShamanism() {
        return shamanism;
    }

    public void setShamanism(Religion shamanism) {
        this.shamanism = shamanism;
    }

    public Religion getTotemism() {
        return totemism;
    }

    public void setTotemism(Religion totemism) {
        this.totemism = totemism;
    }

    public Religion getInti() {
        return inti;
    }

    public void setInti(Religion inti) {
        this.inti = inti;
    }

    public Religion getNahuatl() {
        return nahuatl;
    }

    public void setNahuatl(Religion nahuatl) {
        this.nahuatl = nahuatl;
    }

    public Religion getMesoamericanReligion() {
        return mesoamericanReligion;
    }

    public void setMesoamericanReligion(Religion mesoamericanReligion) {
        this.mesoamericanReligion = mesoamericanReligion;
    }

    public Religion getNorsePaganReformed() {
        return norsePaganReformed;
    }

    public void setNorsePaganReformed(Religion norsePaganReformed) {
        this.norsePaganReformed = norsePaganReformed;
    }

    public Religion getTengriPaganReformed() {
        return tengriPaganReformed;
    }

    public void setTengriPaganReformed(Religion tengriPaganReformed) {
        this.tengriPaganReformed = tengriPaganReformed;
    }

    public Religion getJewish() {
        return jewish;
    }

    public void setJewish(Religion jewish) {
        this.jewish = jewish;
    }

    public Religion getZoroastrian() {
        return zoroastrian;
    }

    public void setZoroastrian(Religion zoroastrian) {
        this.zoroastrian = zoroastrian;
    }

    @Override
    public void parse(String content) {
        content = ParseUtils.getNextObject(content, content.indexOf("religions") + 1);
        this.noReligion = new Religion(ParseUtils.getNextObject(content, content.indexOf("noreligion") + 1));
        this.catholic = new Religion(ParseUtils.getNextObject(content, content.indexOf("catholic") + 1));
        this.anglican = new Religion(ParseUtils.getNextObject(content, content.indexOf("anglican") + 1));
        this.protestant = new Religion(ParseUtils.getNextObject(content, content.indexOf("protestant") + 1));
        this.reformed = new Religion(ParseUtils.getNextObject(content, content.indexOf("reformed") + 1));
        this.orthodox = new Religion(ParseUtils.getNextObject(content, content.indexOf("orthodox") + 1));
        this.coptic = new Religion(ParseUtils.getNextObject(content, content.indexOf("coptic") + 1));
        this.sunni = new Religion(ParseUtils.getNextObject(content, content.indexOf("sunni") + 1));
        this.shiite = new Religion(ParseUtils.getNextObject(content, content.indexOf("shiite") + 1));
        this.ibadi = new Religion(ParseUtils.getNextObject(content, content.indexOf("ibadi") + 1));
        this.buddhism = new Religion(ParseUtils.getNextObject(content, content.indexOf("buddhism") + 1));
        this.vajrayana = new Religion(ParseUtils.getNextObject(content, content.indexOf("vajrayana") + 1));
        this.mahayana = new Religion(ParseUtils.getNextObject(content, content.indexOf("mahayana") + 1));
        this.confucianism = new Religion(ParseUtils.getNextObject(content, content.indexOf("confucianism") + 1));
        this.shinto = new Religion(ParseUtils.getNextObject(content, content.indexOf("shinto") + 1));
        this.hinduism = new Religion(ParseUtils.getNextObject(content, content.indexOf("hinduism") + 1));
        this.sikhism = new Religion(ParseUtils.getNextObject(content, content.indexOf("sikhism") + 1));
        this.animism = new Religion(ParseUtils.getNextObject(content, content.indexOf("animism") + 1));
        this.shamanism = new Religion(ParseUtils.getNextObject(content, content.indexOf("shamanism") + 1));
        this.totemism = new Religion(ParseUtils.getNextObject(content, content.indexOf("totemism") + 1));
        this.inti = new Religion(ParseUtils.getNextObject(content, content.indexOf("inti") + 1));
        this.nahuatl = new Religion(ParseUtils.getNextObject(content, content.indexOf("nahuatl") + 1));
        this.mesoamericanReligion = new Religion(ParseUtils.getNextObject(content, content.indexOf("mesoamerican_religion") + 1));
        this.norsePaganReformed = new Religion(ParseUtils.getNextObject(content, content.indexOf("norse_pagan_reformed") + 1));
        this.tengriPaganReformed = new Religion(ParseUtils.getNextObject(content, content.indexOf("tengri_pagan_reformed") + 1));
        this.jewish = new Religion(ParseUtils.getNextObject(content, content.indexOf("jewish") + 1));
        this.zoroastrian = new Religion(ParseUtils.getNextObject(content, content.indexOf("zoroastrian") + 1));
    }
}
