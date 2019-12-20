
import { ClienteDTO } from '../../dto/cliente.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarClienteService } from '../../services/gestionar-clientes.service';


/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Lenin Narvaez
 */
@Component({
    selector: 'cliente-comic',
    templateUrl: './gestionar-cliente.html',
    styleUrls: ['./gestionar-cliente.css']
})
export class GestionarClienteComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarClienteForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public cliente: ClienteDTO;

    /**
     * Atributo boton crear comic que nos permitira mostrar u ocultar el boton
     */

    public botonCrearCliente: boolean;

    /**
     * Atributo boton actualizar que nos permitira mostrar u ocultar el boton
     */

    public mensajeExito: string;

    public mostrarMensaje: boolean;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaClientes : Array<ClienteDTO>;

    /**
     * Atributo que inicia el idComic en 0
     */

    public idCliente : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Lenin Narvaez
     */
    
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarClienteService : GestionarClienteService) {
        this.gestionarClienteForm = this.fb.group({
            id : [null],
            nombre : [null, Validators.required],
            tipoDocumento : [null],
            documento : [null],
            fechaNac : [null],            
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Lenin Narvaez
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.cliente = new ClienteDTO();
        //this.consultarComic1 = new VerComicComponent();
        this.listaClientes = new Array<ClienteDTO>();        
        this.botonCrearCliente = true;
        this.consultarClientes();
    }

    private consultarClientes(){
        this.gestionarClienteService.consultarClientes().subscribe(listaClientes =>{
            this.listaClientes = listaClientes;
        }, error =>{ 
            console.log("Se ha presentado un error al momento de consultar cliente "+error)
        });
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarCliente() : void {
        this.submitted = true;
        if(this.gestionarClienteForm.invalid) {
            return;
        }
       
        this.cliente = new ClienteDTO();
        this.cliente.id = this.idCliente + "";
        this.cliente.nombre = this.gestionarClienteForm.controls.nombre.value;
        this.cliente.tipoDocumento = this.gestionarClienteForm.controls.tipoDocumento.value;
        this.cliente.documento = this.gestionarClienteForm.controls.documento.value;
        this.cliente.fecha = this.gestionarClienteForm.controls.fechaNac.value;

        this.gestionarClienteService.crearCliente(this.cliente).subscribe(resultado =>{
            this.mostrarMensaje = true;
            this.mensajeExito = resultado.mensajeEjecucion; 
            //if(resultado.exitoso){
                
                this.limpiarFormulario();        
                this.consultarClientes();        
          //  }else {
            //    this.mensajeExito = resultado.mensajeEjecucion; 
           // }
            
        }, error =>{
            console.log("Se ha presentado un error al consumir el servicio");
                        
        });
        
    }
    

    //Metodo para limpiar campos 

    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarClienteForm.controls.nombre.setValue(null);
        this.gestionarClienteForm.controls.tipoDocumento.setValue(null);
        this.gestionarClienteForm.controls.documento.setValue(null);
        this.gestionarClienteForm.controls.fechaNac.setValue(null);        
    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Lenin Narvaez
     */
    get f() { 
        return this.gestionarClienteForm.controls;
    }
}