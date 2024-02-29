import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlumnosPorCursoComponent } from './alumnos-por-curso.component';

describe('AlumnosPorCursoComponent', () => {
  let component: AlumnosPorCursoComponent;
  let fixture: ComponentFixture<AlumnosPorCursoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlumnosPorCursoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AlumnosPorCursoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
