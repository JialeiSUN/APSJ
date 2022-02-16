import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CleUsbComponent } from './cle-usb.component';

describe('CleUsbComponent', () => {
  let component: CleUsbComponent;
  let fixture: ComponentFixture<CleUsbComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CleUsbComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CleUsbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
