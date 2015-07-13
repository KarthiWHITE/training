/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csv_json_mapping;

/**
 *
 * @author cb-admin1
 */
public class MapObj {
    public final String frmCon;
    public final String toCon;
    public final CSV_JSON_mapping.colType col;
    public MapObj(String frmCon,String toCon,CSV_JSON_mapping.colType col){
        this.frmCon=frmCon;
        this.toCon=toCon;
        this.col=col;
    }
}
