import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelFixeComponent } from './tel-fixe.component';

describe('TelFixeComponent', () => {
  let component: TelFixeComponent;
  let fixture: ComponentFixture<TelFixeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelFixeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TelFixeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
