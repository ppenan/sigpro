<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style type="text/css">
	
		.divMapa{
			height: calc(80% - 50px);
			width: 100%;
		}
		
		.label-form2 {
		    font-size: 13px;
		    opacity: 1;
		    color: rgba(0,0,0,0.38) !important;
		    font-weight: bold;
		}
		.label-form2:hover{
			color: rgba(0,0,0,0.5) !important;
			
		}
		
	</style>	
	<%@ page import="org.apache.shiro.SecurityUtils" %>
	<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<div ng-controller="mapaController as mapac" class="maincontainer all_page" id="title">
		
	
	    
	    <script type="text/ng-template" id="modalInfo.html">
        	<div class="modal-header">
            	<h3 class="modal-title" id="modal-title">Datos de {{infoc.objeto.nombreOjetoTipo}}</h3>
        	</div>
        	<div class="modal-body" id="modal-body">

				
				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="id">Id</label>
					</div>
					<div class="col-sm-6">
						 {{infoc.objeto.id }}
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="nombre">Nombre</label>
					</div>
					<div class="col-sm-6">
						{{ infoc.objeto.nombre }}
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="nombre">Usuario que creo</label>
					</div>
					<div class="col-sm-6">
						{{ infoc.objeto.usuarioCreo }}
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="nombre">Fecha de creación</label>
					</div>
					<div class="col-sm-6">
						{{ infoc.objeto.fechaCreacion }}
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="nombre">Usuario que actualizo</label>
					</div>
					<div class="col-sm-6">
						{{ infoc.objeto.usuarioactualizo }}
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="nombre">Fecha de actualizacion</label>
					</div>
					<div class="col-sm-6">
						{{ infoc.objeto.fechaactualizacion }}
					</div>
				</div>

				<div class="row">
					<div class="col-sm-6" style="text-align: right">
						<label for="nombre">Estado</label>
					</div>
					<div class="col-sm-6">
						{{ infoc.objeto.estadoNombre }}
					</div>
				</div>
				

				</div>

        	</div>
        	<div class="modal-footer">
            	<button class="btn btn-primary" type="button" ng-click="infoc.ok()">Aceptar</button>
        	</div>
    </script>
    
    <div class="panel panel-default">
	  <div class="panel-heading"><h3>Mapa</h3></div>
	</div>
	    
		<div class="row" style="width: 100%;">
					<div class="form-group col-sm-4" align="left">
						<select  class="inputText" ng-model="mapac.prestamo"
							ng-options="a.text for a in mapac.prestamos"
							ng-change="mapac.cargar()"></select>
					</div>
		</div>
		<div class="row">
	    <div class="col-sm-12 operation_buttons" align="right" style="width: 99%">
	    
	    
	    	 <div class="checkbox" ng-hide="!mapac.mostrar">
			    <span class="label-form2">
			      <input type="checkbox" ng-model="mostrarTodo" ng-click="mostrar(0)">
			      <span style="font-weight: bold;">Todos</span>
			    </span>
			    &nbsp;&nbsp;&nbsp;&nbsp;
			    <span class="label-form2">
			      <input type="checkbox" ng-model="mostrarProyectos" ng-click="mostrar(1)">
			      <span style="font-weight: bold;">Proyecto</span>
			    </span>
			    &nbsp;&nbsp;&nbsp;&nbsp;
			    <span class="label-form2">
			      <input type="checkbox" ng-model="mostrarComponentes" ng-click="mostrar(2)">
			      <span  ng-dropdown-multiselect="" options="mapac.optionComponentes" selected-model="mapac.estadoComponentes" 
			    	extra-settings="mapac.extraSetingComponentes"
			    	events="mapac.selectComponente">
				    	<toggle-dropdown>
				    		Componentes
				    		<span class="glyphicon glyphicon-menu-down"></span>
				    	</toggle-dropdown>
			      </span>
			    </span>
			    &nbsp;&nbsp;&nbsp;&nbsp;
			    <span class="label-form2">
			      <input type="checkbox" ng-model="mostrarProductos" ng-click="mostrar(3)">
			      <span  ng-dropdown-multiselect="" options="mapac.optionProductos" selected-model="mapac.estadoProductos" 
			    	extra-settings="mapac.extraSetingProductos"
			    	events="mapac.selectProducto">
				    	<toggle-dropdown>
				    		Productos
				    		<span class="glyphicon glyphicon-menu-down"></span>
				    	</toggle-dropdown>
			      </span>
			    </span>
			    &nbsp;&nbsp;&nbsp;&nbsp;
			    <span class="label-form2">
			      <input type="checkbox" ng-model="mostrarSubproductos" ng-click="mostrar(4)">
			      <span  ng-dropdown-multiselect="" options="mapac.optionSubproductos" selected-model="mapac.estadoSubproductos" 
			    	extra-settings="mapac.extraSetingSubproductos"
			    	events="mapac.selectSubproducto">
				    	<toggle-dropdown>
				    		Subproductos
				    		<span class="glyphicon glyphicon-menu-down"></span>
				    	</toggle-dropdown>
			      </span>	
			    </span>
			    &nbsp;&nbsp;&nbsp;&nbsp;
			    <span class="label-form2">
			    	<input type="checkbox" ng-model="mostrarActividades" ng-click="mostrar(5)" >
			    	<span  ng-dropdown-multiselect="" options="mapac.transclusionData" selected-model="mapac.transclusionModel" 
			    	extra-settings="mapac.transclusionSettings"
			    	events="mapac.selectActividad">
				    	<toggle-dropdown>
				    		Actividades
				    		<span class="glyphicon glyphicon-menu-down"></span>
				    	</toggle-dropdown>
			    	</span>	
			    </span>
		    	
			    
			    
			    
			    
			    
			  </div>
	    	 
	    </div>
	    </div>
        <div class=" modal-body row divMapa"  >
        	  <div class=" divMapa" >
	        	<ui-gmap-google-map id="mainmap"  center="map.center" zoom="map.zoom" options="map.options" events="map.events"
	        	ng-if="mapac.mostrar"  >
	      			
					<div ng-repeat="marca in marcas track by marca.id">
						<div ng-switch on ="marca.objetoTipoId">
							<div ng-switch-when="1">
								<ui-gmap-marker ng-if="mostrarTodo || mostrarProyectos" 
									 idkey="marca.id" coords="marca.posicion" icon = "marca.icon"
									 click="abrirInformacion(marca.objetoId,marca.objetoTipoId,marca.idEstado,marca.porcentajeEstado)" 
									 options="{title:marca.nombre}"  
									 >
								 </ui-gmap-marker>
							 </div>
							 <div ng-switch-when="2">
								<ui-gmap-marker ng-if="mostrarTodo || (mostrarComponentes && marca.mostrar)" 
									 idkey="marca.id" coords="marca.posicion" icon = "marca.icon"
									 click="abrirInformacion(marca.objetoId,marca.objetoTipoId,marca.idEstado,marca.porcentajeEstado)" 
									 options="{title:marca.nombre}"  
									 >
								 </ui-gmap-marker>
							 </div>
							 <div ng-switch-when="3">
								<ui-gmap-marker ng-if="mostrarTodo || (mostrarProductos && marca.mostrar )" 
									 idkey="marca.id" coords="marca.posicion" icon = "marca.icon"
									 click="abrirInformacion(marca.objetoId,marca.objetoTipoId,marca.idEstado,marca.porcentajeEstado)" 
									 options="{title:marca.nombre}"  
									 >
								 </ui-gmap-marker>
							 </div>
							 <div ng-switch-when="4">
								<ui-gmap-marker ng-if="mostrarTodo || (mostrarSubproductos && marca.mostrar )" 
									 idkey="marca.id" coords="marca.posicion" icon = "marca.icon"
									 click="abrirInformacion(marca.objetoId,marca.objetoTipoId,marca.idEstado,marca.porcentajeEstado)" 
									 options="{title:marca.nombre}"  
									 >
								 </ui-gmap-marker>
							 </div>
							 <div ng-switch-when="5">
								<ui-gmap-marker ng-if="mostrarTodo || (mostrarActividades && marca.mostrar)" 
									 idkey="marca.id" coords="marca.posicion" icon = "marca.icon"
									 click="abrirInformacion(marca.objetoId,marca.objetoTipoId,marca.idEstado,marca.porcentajeEstado)" 
									 options="{title:marca.nombre}"  
									 >
								 </ui-gmap-marker>
							 </div>
						</div>
					</div>
				</ui-gmap-google-map>
			</div>
		</div>
		<br>
	</div>
