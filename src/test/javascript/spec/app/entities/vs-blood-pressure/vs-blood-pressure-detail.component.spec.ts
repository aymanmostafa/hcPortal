/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

import { HcPortalTestModule } from '../../../test.module';
import { VsBloodPressureDetailComponent } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure-detail.component';
import { VsBloodPressureService } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure.service';
import { VsBloodPressure } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure.model';

describe('Component Tests', () => {

    describe('VsBloodPressure Management Detail Component', () => {
        let comp: VsBloodPressureDetailComponent;
        let fixture: ComponentFixture<VsBloodPressureDetailComponent>;
        let service: VsBloodPressureService;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBloodPressureDetailComponent],
                providers: [
                    VsBloodPressureService
                ]
            })
            .overrideTemplate(VsBloodPressureDetailComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBloodPressureDetailComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBloodPressureService);
        });

        describe('OnInit', () => {
            it('Should call load all on init', () => {
                // GIVEN

                spyOn(service, 'find').and.returnValue(Observable.of(new HttpResponse({
                    body: new VsBloodPressure('123')
                })));

                // WHEN
                comp.ngOnInit();

                // THEN
                expect(service.find).toHaveBeenCalledWith('123');
                expect(comp.vsBloodPressure).toEqual(jasmine.objectContaining({id: '123'}));
            });
        });
    });

});
