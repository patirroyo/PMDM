package Controladores;

import Modelos.Proyecto;
import Controladores.util.JsfUtil;
import Controladores.util.PaginationHelper;
import Modelos.Cadsub;
import Modelos.Crs;
import Modelos.Entidad;
import Modelos.Envio;
import Modelos.Inspectoria;
import Modelos.Tipoentidad;
import Modelos.Sede;
import Modelos.Tecnico;

import Repositorios.ProyectoFacade;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("proyectoController")
@SessionScoped
public class ProyectoController implements Serializable {

    private Proyecto current;
    private DataModel items = null;
    @EJB
    private Repositorios.ProyectoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    
    //Son para ProyectoEnvio    
    private Proyecto proyecto;
    private Double suma = 0.0;
    private Double diferencia = 0.0;
    private String mensaje = null;
    private List<Envio> listaEnvio;
    
    //Son para ProyectoCompleto
    private Proyecto proyectoCompleto;
    private Inspectoria inspectoriaProyectoCompleto;
    private Sede sedeProyectoCompleto;
    private List<Envio> listaDeEnvioProyectoCompleto;
    private List<Crs> listaCrsProyectoCompleto;
    private Cadsub cadsubProyectoCompleto;
    private Tecnico tecSeg;
    private Tecnico tecFor;
    private Entidad entidadProyectoCompleto;
    private Tipoentidad tipoEntidadProyectoCompleto;
    
    
    public ProyectoController() {
    }

    public Double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(Double diferencia) {
        this.diferencia = diferencia;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    public Tecnico getTecSeg() {
        return tecSeg;
    }

    public void setTecSeg(Tecnico tecSeg) {
        this.tecSeg = tecSeg;
    }

    public Tecnico getTecFor() {
        return tecFor;
    }

    public void setTecFor(Tecnico tecFor) {
        this.tecFor = tecFor;
    }

    public Proyecto getCurrent() {
        return current;
    }

    public void setCurrent(Proyecto current) {
        this.current = current;
    }
    
    public Entidad getEntidadProyectoCompleto() {
        return entidadProyectoCompleto;
    }

    public void setEntidadProyectoCompleto(Entidad entidadProyectoCompleto) {
        this.entidadProyectoCompleto = entidadProyectoCompleto;
    }

    public Tipoentidad getTipoEntidadProyectoCompleto() {
        return tipoEntidadProyectoCompleto;
    }

    public void setTipoEntidadProyectoCompleto(Tipoentidad tipoEntidadProyectoCompleto) {
        this.tipoEntidadProyectoCompleto = tipoEntidadProyectoCompleto;
    }

    
    public List<Crs> getListaCrsProyectoCompleto() {
        return listaCrsProyectoCompleto;
    }

    public void setListaCrsProyectoCompleto(List<Crs> listaCrsProyectoCompleto) {
        this.listaCrsProyectoCompleto = listaCrsProyectoCompleto;
    }

    
    public List<Envio> getListaDeEnvioProyectoCompleto() {
        return listaDeEnvioProyectoCompleto;
    }

    public void setListaDeEnvioProyectoCompleto(List<Envio> listaDeEnvioProyectoCompleto) {
        this.listaDeEnvioProyectoCompleto = listaDeEnvioProyectoCompleto;
    }

    public Sede getSedeProyectoCompleto() {
        return sedeProyectoCompleto;
    }

    public void setSedeProyectoCompleto(Sede sedeProyectoCompleto) {
        this.sedeProyectoCompleto = sedeProyectoCompleto;
    }
    
    public Proyecto getProyectoCompleto() {
        return proyectoCompleto;
    }

    public void setProyectoCompleto(Proyecto proyectoCompleto) {
        this.proyectoCompleto = proyectoCompleto;
    }

    public Inspectoria getInspectoriaProyectoCompleto() {
        return inspectoriaProyectoCompleto;
    }

    public void setInspectoriaProyectoCompleto(Inspectoria inspectoriaProyectoCompleto) {
        this.inspectoriaProyectoCompleto = inspectoriaProyectoCompleto;
    }
    
    
    
    
    public Double getSuma() {
        return suma;
    }

    public void setSuma(Double suma) {
        this.suma = suma;
    }

    public List<Envio> getListaEnvio() {
        return listaEnvio;
    }

    public void setListaEnvio(List<Envio> listaEnvio) {
        this.listaEnvio = listaEnvio;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }
    public Proyecto getSelected() {
        if (current == null) {
            current = new Proyecto();
            selectedItemIndex = -1;
        }
        return current;
    }

    private ProyectoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Proyecto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Proyecto();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Proyecto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Proyecto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("ProyectoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return getSelectProyecto(ejbFacade.proyectosOrdenados(), false); //el boolean sirve para elegir si es uno o muchos, si pones el true es que es solo uno y te mostraría el mensaje predifinido en el item 0
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return getSelectProyecto(ejbFacade.proyectosOrdenados(), false);
    }

    public Proyecto getProyecto(java.lang.Integer id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = Proyecto.class, value="proyectoConverter")
    public static class ProyectoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ProyectoController controller = (ProyectoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "proyectoController");
            return controller.getProyecto(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Proyecto) {
                Proyecto o = (Proyecto) object;
                return getStringKey(o.getCodProyecto());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + Proyecto.class.getName());
            }
        }

    }
    
    public static SelectItem[] getSelectProyecto(List<Proyecto> entities, boolean selectOne) { // le pasamos la lista de Cad
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("0", "Elige un proyecto");
            i++;
        }//nombre del objeto : y la lista, todos los objetos del mundo mundial son de la superclase Object
        for (Proyecto x : entities) { // lee objetos de la clase cad
            items[i++] = new SelectItem(x, x.getCodigo()); // le ponemos el objeto cad (x) y el nombre del 
        }
        return items;
    }
    
//    public void cargarListaDeEnvioDeUnProyecto(){
//        listaEnvio = ejbFacade.EnvioPorProyecto(proyecto);
//    }
    
    //Para envio proyecto
    public void cargarListaDeEnvioDeUnProyecto(){
        suma = 0.0;
        diferencia = null;
        if(proyecto != null){
            listaEnvio = ejbFacade.EnvioPorProyecto(proyecto);
            if(proyecto.getDineroConcedido() != null)//Si no se le ha concedido dinero no se saca la diferencia y sera 0
                mensaje = calcularCositas();
            else
                mensaje = "No se ha concedido pasta a este proyecto";
        }
    }
    
    //Para envio proyecto
    public String calcularCositas(){
        for(Envio env: listaEnvio)
            suma += env.getCantidad();
        
        
        diferencia = proyecto.getDineroConcedido() - suma;
        
        
        if (diferencia >= 0.0){
            return diferencia.toString();
        }
        else{
            return "Has gastado más de lo concedido";
        }
    }
    
    public void cargarListaProyectoCompleto(){
        inspectoriaProyectoCompleto = ejbFacade.inspectoriaProyectoCompleto(proyectoCompleto);
        sedeProyectoCompleto = ejbFacade.sedeProyectoCompleto(proyectoCompleto);
        
        //Reutilizamos la funcion del facade que hemos creado previamente para recuperar los envios de un proyecto
        listaDeEnvioProyectoCompleto = ejbFacade.EnvioPorProyecto(proyectoCompleto); 
        
        //No necesitamos ir a consultar los CRS del proyecto porque el proyecto ya tiene una lista con sus CRS
        if(proyectoCompleto != null){
            listaCrsProyectoCompleto =  proyectoCompleto.getCrsList();
//            cadsubProyectoCompleto = ejbFacade.cadsubProyectoCompleto(listaCrsProyectoCompleto.indexOf(0));
        }
        else{
            listaCrsProyectoCompleto = null;
        }
        
        entidadProyectoCompleto = ejbFacade.entidadProyectoCompleto(proyectoCompleto);
        tipoEntidadProyectoCompleto = ejbFacade.tipoEntidadProyectoCompleto(proyectoCompleto);
        tecFor = ejbFacade.tecnicoDeProyectoFormacionCompleto(proyectoCompleto);
        tecSeg = ejbFacade.tecnicoDeProyectoSeguimientoCompleto(proyectoCompleto); 
    }
    
        
        
        
}
