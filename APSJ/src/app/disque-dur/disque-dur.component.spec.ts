import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisqueDurComponent } from './disque-dur.component';

describe('DisqueDurComponent', () => {
  let component: DisqueDurComponent;
  let fixture: ComponentFixture<DisqueDurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisqueDurComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisqueDurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
