
import { ComicDTO } from '../../dto/comic.dto';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
 */
@Component({
    selector: 'ver-comic',
    templateUrl: './ver-comic-component.html',
    
})
export class VerComicComponent implements OnInit {
    

    /**
     * Atributo que contiene los controles del formulario
     */
    public verComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public comic: ComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaComics : Array<ComicDTO>;

    public idComic : number = 0;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    

    constructor(private fb : FormBuilder, private activatedRoute: ActivatedRoute, private router : Router) {

        this.verComicForm = this.fb.group({
            nombre : [null],
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
        
        this.f.nombre.setValue(this.p.nombre);
        this.f.editorial.setValue(this.p.editorial);
        this.f.tematica.setValue(this.p.tematica);
        this.f.coleccion.setValue(this.p.coleccion);
        this.f.numeroPaginas.setValue(this.p.numeroPaginas);
        this.f.precio.setValue(this.p.precio);
        this.f.autores.setValue(this.p.autores);
        this.f.color.setValue(this.p.color);
        this.f.nombre.disable();
        this.f.editorial.disable();
        this.f.tematica.disable();
        this.f.coleccion.disable();
        this.f.numeroPaginas.disable();
        this.f.precio.disable();
        this.f.autores.disable();
        this.f.color.disable();
        
    }

    /**
     * @description Metodo que permite validar el formulario y crear o actulizar un comic
     */


    /**
     * Metodo que permite consultar un comic de la tabla y sus detalles e inhabilitar el formulario
     * @param posicion en la lista del comic seleccionado
     */
    public consultarComic(posicion : number) : void {
        let comic = this.listaComics[posicion];
        this.verComicForm.controls.nombre.setValue(comic.nombre);
        this.verComicForm.controls.editorial.setValue(comic.editorial);
        this.verComicForm.controls.tematica.setValue(comic.tematica);
        this.verComicForm.controls.coleccion.setValue(comic.coleccion);
        this.verComicForm.controls.numeroPaginas.setValue(comic.numeroPaginas);
        this.verComicForm.controls.precio.setValue(comic.precio);
        this.verComicForm.controls.autores.setValue(comic.autores);
        this.verComicForm.controls.color.setValue(comic.color);
        this.verComicForm.controls.nombre.disable();
        this.verComicForm.controls.editorial.disable();
        this.verComicForm.controls.tematica.disable();
        this.verComicForm.controls.coleccion.disable();
        this.verComicForm.controls.numeroPaginas.disable();
        this.verComicForm.controls.precio.disable();
        this.verComicForm.controls.autores.disable();
        this.verComicForm.controls.color.disable();
//        this.gestionarComicForm.controls.color.enable(); para habilitar el campo

    }    

    volverGestionarComic(){

    }

    

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.verComicForm.controls;
    }

    get p(){
        return this.activatedRoute.snapshot.params;
    }
}