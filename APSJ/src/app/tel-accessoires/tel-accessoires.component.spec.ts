import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TelAccessoiresComponent } from './tel-accessoires.component';

describe('TelAccessoiresComponent', () => {
  let component: TelAccessoiresComponent;
  let fixture: ComponentFixture<TelAccessoiresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TelAccessoiresComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TelAccessoiresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
