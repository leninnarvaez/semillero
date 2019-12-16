
import { ComicDTO } from '../../dto/comic.dto';
//import { VerComicComponent } from '../../verComic/ver-comic-component';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { VerComicComponent } from '../verComic/ver-comic-component';


/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'gestionar-comic',
    templateUrl: './gestionar-comic.html',
    styleUrls: ['./gestionar-comic.css']
})
export class GestionarComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo boton crear comic que nos permitira mostrar u ocultar el boton
     */

    public botonCrearComic: boolean;

    /**
     * Atributo boton actualizar que nos permitira mostrar u ocultar el boton
     */

    public botonActualizarComic: boolean;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    /**
     * Atributo que inicia el idComic en 0
     */

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    
    constructor(private fb : FormBuilder,
        private router : Router) {
        this.gestionarComicForm = this.fb.group({
            id : [null],
            nombre : [null, Validators.required],
            editorial : [null],
            tematica : [null],
            coleccion : [null],
            numeroPaginas : [null],
            precio : [null],
            autores : [null],
            color : [null]
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.comic = new ComicDTO();
        //this.consultarComic1 = new VerComicComponent();
        this.listaComics = new Array<ComicDTO>();        
        this.botonCrearComic = true;
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */
    public crearActualizarComic() : void {
        this.submitted = true;
        if(this.gestionarComicForm.invalid) {
            return;
        }
        this.idComic++;
        this.comic = new ComicDTO();
        this.comic.id = this.idComic + "";
        this.comic.nombre = this.gestionarComicForm.controls.nombre.value;
        this.comic.editorial = this.gestionarComicForm.controls.editorial.value;
        this.comic.tematica = this.gestionarComicForm.controls.tematica.value;
        this.comic.coleccion = this.gestionarComicForm.controls.coleccion.value;
        this.comic.numeroPaginas = this.gestionarComicForm.controls.numeroPaginas.value;
        this.comic.precio = this.gestionarComicForm.controls.precio.value;
        this.comic.autores = this.gestionarComicForm.controls.autores.value;
        this.comic.color = this.gestionarComicForm.controls.color.value;        
        this.listaComics.push(this.comic);
        this.limpiarFormulario();        
    }

    //Metodo para navegar al componente ver comic

    public mostrarComic(comic: ComicDTO): void {
        this.router.navigate(['ver-comic', comic]);
    }

    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
        
    /*       
    public consultarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);
        this.gestionarComicForm.controls.nombre.disable();
        this.gestionarComicForm.controls.editorial.disable();
        this.gestionarComicForm.controls.tematica.disable();
        this.gestionarComicForm.controls.coleccion.disable();
        this.gestionarComicForm.controls.numeroPaginas.disable();
        this.gestionarComicForm.controls.precio.disable();
        this.gestionarComicForm.controls.autores.disable();
        this.gestionarComicForm.controls.color.disable();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo
    }
*/

    //Metodo que rellena los campos de texto para actualizarlos

    public editarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.gestionarComicForm.controls.nombre.setValue(comic.nombre);
        this.gestionarComicForm.controls.editorial.setValue(comic.editorial);
        this.gestionarComicForm.controls.tematica.setValue(comic.tematica);
        this.gestionarComicForm.controls.coleccion.setValue(comic.coleccion);
        this.gestionarComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.gestionarComicForm.controls.precio.setValue(comic.precio);
        this.gestionarComicForm.controls.autores.setValue(comic.autores);
        this.gestionarComicForm.controls.color.setValue(comic.color);

        // Se oculta el boton para registrar nuevos comics
        this.botonCrearComic = false;

        // Se muestra el boton para actualizar comics
        this.botonActualizarComic = true;
    }

    //Metodo para actualizar comic 

    public actualizarComic(): void {
        this.submitted = true;

        if (this.gestionarComicForm.invalid) { 
            return;
        }

        // Creación de un nuevo Comic para llenar con nuevos datos
        this.comic = new ComicDTO();
                
        this.comic.id = this.f.id.value;
        console.log("ID = " + this.f.id.value);
        this.comic.nombre = this.f.nombre.value;
        this.comic.editorial = this.f.editorial.value;
        this.comic.tematica = this.f.tematica.value;
        this.comic.coleccion = this.f.coleccion.value;
        this.comic.numeroPaginas = this.f.numeroPaginas.value;
        this.comic.precio = this.f.precio.value;
        this.comic.autores = this.f.autores.value;
        this.comic.color = this.f.color.value;

        //Se elimina el comic señalado y se remplaza por la actualizacion
        this.listaComics.splice((this.f.id.value)-1, 1, this.comic);
        this.limpiarFormulario();

        // Mostrar boton crear comic
        this.botonCrearComic = true;

        // Ocultamos boton actualizar comic
        this.botonActualizarComic = false;    
    }

    //Metodo para eliminar comic

    public eliminarComic(posicion : number): void{       
        this.listaComics.splice((posicion), 1);
    }


    //Metodo para limpiar campos 

    private limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarComicForm.controls.nombre.setValue(null);
        this.gestionarComicForm.controls.editorial.setValue(null);
        this.gestionarComicForm.controls.tematica.setValue(null);
        this.gestionarComicForm.controls.coleccion.setValue(null);
        this.gestionarComicForm.controls.numeroPaginas.setValue(null);
        this.gestionarComicForm.controls.precio.setValue(null);
        this.gestionarComicForm.controls.autores.setValue(null);
        this.gestionarComicForm.controls.color.setValue(null);
    }


    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarComicForm.controls;
    }
}